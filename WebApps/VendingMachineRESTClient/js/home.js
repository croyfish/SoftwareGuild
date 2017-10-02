var moneyEntered = 0;
var moneyNeeded = 0;
var moneyShort = false;

$(document).ready(function () {
  
  var startup = new Audio('sounds/startup.mp3');
  startup.play();

  fillMachine();

  //var moneyEntered = 0;

   $('#addDollar').click(function (event) {
    var enter_dollar = new Audio('sounds/enter_dollar.mp3');
    enter_dollar.play();

    moneyEntered += 100;
    var moneyString = "$" + (moneyEntered / 100).toFixed(2);
    $('#moneyInserted').val(moneyString);
    if (moneyNeeded > 0 && moneyShort) {
      getChangeRemaining();
    }

   });

   $('#addQuarter').click(function (event) {
    var quarter_drop = new Audio('sounds/coin_drop.mp3');
    quarter_drop.play();
    moneyEntered += 25;
    var moneyString = "$" + (moneyEntered / 100).toFixed(2);
    $('#moneyInserted').val(moneyString);
    if (moneyNeeded > 0 && moneyShort) {
      getChangeRemaining();
    }

   });

   $('#addDime').click(function (event) {
    var dime_drop = new Audio('sounds/coin_drop.mp3');
    dime_drop.play();
    moneyEntered += 10;
    var moneyString = "$" + (moneyEntered / 100).toFixed(2);
    $('#moneyInserted').val(moneyString);
    if (moneyNeeded > 0 && moneyShort) {
      getChangeRemaining();
    }

   });

   $('#addNickel').click(function (event) {
    var nickel_drop = new Audio('sounds/coin_drop.mp3');
    nickel_drop.play();
    moneyEntered += 5;
    var moneyString = "$" + (moneyEntered / 100).toFixed(2);
    $('#moneyInserted').val(moneyString);
    if (moneyNeeded > 0 && moneyShort) {
      getChangeRemaining();
    }

   });

   $('#makePurchase').click(function (event) {

    var userSelection = $('#itemSelection').val();
    var urlString = 'http://localhost:8080/money/' + (moneyEntered / 100) + '/item/' + userSelection;
    var changeString = '';

    $.ajax({
      type: 'GET',
      url: urlString,
      success: function (change) {
        console.log('Call was successful.');
        var vend_item = new Audio('sounds/vend_item.mp3');
        vend_item.play();
        var change_return = new Audio('sounds/coin_return.mp3');
        var quarters = change.quarters;
        var dimes = change.dimes;
        var nickels = change.nickels;
        var pennies = change.pennies;
        if (quarters) {
          changeString += quarters + ((quarters > 1) ? ' quarters  ' : ' quarter  ');
          change_return.play();
        }
        if (dimes) {
          changeString += dimes + ((dimes > 1) ? ' dimes  ' : ' dime  ');
          change_return.play();
        }
        if (nickels) {
          changeString += nickels + ((nickels > 1) ? ' nickels  ' : ' nickel  ');
          change_return.play();
        }
        if (pennies) {
          changeString += pennies + ((pennies > 1) ? ' pennies  ' : ' penny  ');
          change_return.play();
        }
        if (changeString == '') {
          changeString = "(No change. Please click here.)"
        }
        $('#changeReturned').val(changeString);
        
        $('#moneyInserted').val("$0.00");
        moneyEntered = 0;
        moneyNeeded = 0;
        moneyShort = false;
        clearSelection();
        $('#messages').css('color', 'green');
        $('#messages').val('Thank you!!! Please click on your change below.');
        updateMachine();

      },
        error: function (err) {
          var buzzer = new Audio('sounds/buzzer.mp3');
          buzzer.play();
          moneyShort = true;
          $('#messages').val(err.responseJSON.message);
          $('#messages').css('color', 'red');
          var messageString = (err.responseJSON.message).split(' ');
          moneyNeeded = moneyEntered + parseInt(100 * parseFloat(messageString[2]));
        }
    });

   });

  $('#returnChange').click(function (event) {

    var audio = new Audio('sounds/register.wav');
    audio.play();

    var changeString = '';
    var quarters = 0;
    var dimes = 0;
    var nickels = 0;
    var pennies = 0;

    quarters = parseInt(moneyEntered / 25);
    moneyEntered = moneyEntered - (quarters * 25);
    dimes = parseInt(moneyEntered / 10);
    moneyEntered = moneyEntered - (dimes * 10);
    nickels = parseInt(moneyEntered / 5);
    moneyEntered = moneyEntered - (nickels * 5);
    pennies = parseInt(moneyEntered / 1);
    moneyEntered = moneyEntered - (pennies);

    if (quarters) {
      changeString += quarters + ((quarters > 1) ? ' quarters  ' : ' quarter  ');
    }
    if (dimes) {
      changeString += dimes + ((dimes > 1) ? ' dimes  ' : ' dime  ');
    }
    if (nickels) {
      changeString += nickels + ((nickels > 1) ? ' nickels  ' : ' nickel  ');
    }
    if (pennies) {
      changeString += pennies + ((pennies > 1) ? ' pennies  ' : ' penny  ');
    }
    if (changeString == '') {
      changeString = "(No change. Please click here.)"
    }

    clearSelection();
    $('#itemSelection').val('');
    $('#changeReturned').val(changeString);

    $('#moneyInserted').val('$0.00');
    moneyEntered = 0;

    $('#messages').css('color', 'green');
    $('#messages').val('Please click on your change below.');

  });

});

function fillMachine() {
  $.ajax({
    type: 'GET',
    url: 'http://localhost:8080/items',
    success: function (items) {
      console.log('Call was successful.');
      

      $.each(items, function(index, item) {
        $('#img' + item.id).append('<img src = "images/' + item.id +'.jpg" height = "50px">');
        var string = '#slot';
        string += (index + 1);
        var price = Number(item.price).toFixed(2);
        $(string).append('<br>$' + price + '<br>' + 'Quanitity Left: ' + item.quantity);
      });
    },
    error: function () {
      console.log('Server cannot be contacted.');
    }
  });
}

function updateMachine() {
  $.ajax({
    type: 'GET',
    url: 'http://localhost:8080/items',
    success: function (items) {
      console.log('Call was successful.');
      

      $.each(items, function(index, item) {
        var string = '#slot';
        string += (index + 1);
        var price = Number(item.price).toFixed(2);
        $(string).html('<br>$' + price + '<br>' + 'Quanitity Left: ' + item.quantity);
      });
    },
    error: function () {
      console.log('Server cannot be contacted.');
    }
  });
}

function selectItem(itemNumber) {
  var select = new Audio('sounds/select.mp3');
  select.play();
  $('#itemSelection').val(itemNumber);
  $('#messages').css('color', 'green');
  $('#messages').val('(no messages)');
  clearSelection();
  $('#box' + itemNumber).css('background-color', 'yellow');
}

function takeChange() {
  var all_clear = new Audio('sounds/all_clear.mp3');
  all_clear.play();
  $('#changeReturned').val('(no change)');
  $('#messages').css('color', 'green');
  $('#messages').val('(no messages)');
  $('#itemSelection').val('');
  clearSelection();
}

function clearSelection() {
  for (var index = 1; index < 10; index++) {
    $('#box' + index).css('background-color', 'white');
  }
}

function getChangeRemaining() {

  var difference = moneyNeeded - moneyEntered;
  if (difference > 0) {
    moneyShort = true;
    $('#messages').css('color', 'red');
    $('#messages').val('Please deposit: ' + (difference / 100).toFixed(2));
  } else {
    moneyShort = false;
    $('#messages').css('color', 'green');
    $('#messages').val("Funds sufficient to purchase selected item.");
  }

}

function getWeather() {
  var weather = new Audio('sounds/weather.mp3');
  weather.play();
  var url = 'http://api.openweathermap.org/data/2.5/weather?zip=44223,us&APPID=cc08accb44c0bf33cc9f1cc717791676';
  var cur;
  var curTemp;

  $.ajax({
    type: 'GET',
    url: url,
    success: function (currentWeather) {

      var cur = currentWeather.weather[0].main;
      var curTemp = Math.round((1.8 * (currentWeather.main.temp - 273)) + 32);
      $('#messages').val('It is ' + curTemp + 'F and ' + cur);

    },
    error: function () {          
      var buzzer = new Audio('sounds/buzzer.mp3');
      buzzer.play();
    }
  });
}