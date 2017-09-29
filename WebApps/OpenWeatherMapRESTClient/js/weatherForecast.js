$(document).ready(function () {

console.log("we got here.");

  //     // Add Button onclick handler
  $('#get-weather-button').click(function (event) {

    //         // check for errors and display any that we have
    //         // pass the input associated with the add form to the validation function
    //         var haveValidationErrors = checkAndDisplayValidationErrors($('#add-form').find('input'));

    //         // if we have errors, bail out by returning false
    //         if (haveValidationErrors) {
    //             return false;
    //         }

    //         // if we made it here, there are no errors so make the ajax call
    console.log("we got here.");

    var zip = $('#zipcode').val();
    console.log(zip);

    var url1 = 'http://api.openweathermap.org/data/2.5/weather?zip=';
    var url2 = ',us&APPID=cc08accb44c0bf33cc9f1cc717791676';
    var urlF = url1 + zip + url2;

    var cur;
    var curIcon;
    var curTemp;
    var curHumid;
    var curWind;

    $.ajax({
      type: 'GET',
      url: urlF,
      success: function (currentWeather) {
        var cur = currentWeather.weather[0].main;
        var curIcon = currentWeather.weather[0].icon;
        var curTemp = Math.round((currentWeather.main.temp - 241) * (9/5));
        var curHumid = currentWeather.main.humidity;
        var curWind = currentWeather.wind.speed;
        console.log(cur);
        console.log(curIcon);
        console.log(curTemp);
        console.log(curHumid);
        console.log(curWind);


      },
      error: function () {
        $('#errorMessages')
          .append($('<li>')
            .attr({ class: 'list-group-item list-group-item-danger' })
            .text('Error calling web service.  Please try again later.'));
      }
    });


    var contentRows2 = $('#contentRows2');
    contentRows2.empty();
    url1 = 'http://api.openweathermap.org/data/2.5/forecast?zip=';
    url2 = ',us&APPID=cc08accb44c0bf33cc9f1cc717791676';
    urlF = url1 + zip + url2;

    $.ajax({
      type: 'GET',
      // url: 'http://api.openweathermap.org/data/2.5/forecast?zip=44221,us&APPID=cc08accb44c0bf33cc9f1cc717791676',
      url: urlF,
      success: function (fiveDayThreeHour) {

        var city = fiveDayThreeHour.city.name;
        $('#currentConditionsBanner').show();
        $('#currentConditionsBanner').html('<h1>Current Conditions in ' + city + '</h1>');
        $('#currentConditionsTable').show();
        $('#fiveDayForecastBanner').show();
        $('#forecastTable').show();

        var row = '<tr>';
        var row2 = '';
        var row3 = '';
        var row4 = '';

          $.each(fiveDayThreeHour.list, function(index, day) {
            console.log(day.dt_txt);
            //console.log(day.weather[0].main);
            dateTime = day.dt_txt.split('-');
            var time = dateTime[2].split(' ');
            console.log(time[1]);

            if (time[1] == "12:00:00") {
              var monthString = returnMonthString(dateTime[1]);
              console.log(monthString);
              row += '<td>' + monthString + ' ' + time[0] + '</td>';
              row2 += day.weather[0].main + ',';
              row3 += day.weather[0].icon + ',';
              console.log(day.main.temp);
              row4 += day.main.temp + ',';
            }

          });
          row += '</tr>';
          contentRows2.append(row);

          var row2P = row2.split(',');
          var row3P = row3.split(',');
          var row4P = row4.split(',');
          console.log(row2P); 
          var row2F = '<tr>';
          var row3F = '<tr>';
          var row4F = '<tr>';
          for (var index = 0; index < 5; index++) {
            row2F += '<td>' + row2P[index] + '</td>';
            var r3Fstr = 'http://openweathermap.org/img/w/';
            r3Fstr += row3P[index];
            r3Fstr += '.png>'
            row3F += '<td>' + '<img src=' + r3Fstr + '</td>';
            var temp = Math.round((row4P[index] - 241) * (9/5));
            row4F += '<td>' + temp + ' &#8457;</td>';
          }
          row2F += '</tr>';
          row3F += '</tr>';
          row4F += '</tr>';
          contentRows2.append(row2F);
          contentRows2.append(row3F);
          contentRows2.append(row4F);

          var contentRow = $('#contentRow');
          var row1C = '<tr><td>' + cur + '</td>';
          var row2C = '<td>' + curTemp + '</td>';
          var row3C = '<td>' + curHumid + '</td></tr>';
          // var row4C = '<tr>' + curWind + '</tr>';
          // var row5C = '<tr>' + curIcon + '</tr>'; 

          contentRow.append('<tr><td>1</td><td>2</td><td>3</td>');
 //         contentRow.append(row1C + row2C + row3C);
          // contentRow.append(row1C);
          // contentRow.append(row1C);
          // contentRow.append(row1C);
          // contentRow.append(row1C);

          
          
          

      //     var dateTime = weatherReading.list.dt_txt.split("-"); // "2017-09-29 09:00:00"
      //     console.log(dateTime);
      //     var time = dateTime[2].split(" ");
      //     console.log(time);
      //     if (time[1] == "12:00:00") {
      //       var monthString = returnMonthString(dateTime[1]);
      //       console.log(monthString);
      //       // var name = contact.firstName + ' ' + contact.lastName;
      //       // var company = contact.company;
      //       // var id = contact.contactId;
      //       var row = '<tr>';
      //       row += '<td>' + monthString + '</td>';
      //       // row += '<td>' + company + '</td>';
      //       // row += '<td><a onclick="showEditForm(' + id + ')">Edit</a></td>';
      //       // row += '<td><a onclick="deleteContact(' + id + ')">Delete</a></td>';
      //       // row += '</tr>';
      //       contentRows.append(row);
      //     }
      //   });
      },
      error: function () {
        $('#errorMessages')
          .append($('<li>')
            .attr({ class: 'list-group-item list-group-item-danger' })
            .text('Error calling web service.  Please try again later.'));
      }
    });
  });
});

function returnMonthString(mm) {
  var month = new Array();
  month[0] = "January";
  month[1] = "February";
  month[2] = "March";
  month[3] = "April";
  month[4] = "May";
  month[5] = "June";
  month[6] = "July";
  month[7] = "August";
  month[8] = "September";
  month[9] = "October";
  month[10] = "November";
  month[11] = "December";
  console.log(parseInt(mm));
  //console.log(parseInt(mm) + 1));
  return month[parseInt(mm) - 1];
}

//         error: function() {
//             $('#errorMessages')
//                 .append($('<li>')
//                 .attr({class: 'list-group-item list-group-item-danger'})
//                 .text('Error calling web service.  Please try again later.'));
//         }
//     });
// }

// function clearContactTable() {
//     $('#contentRows').empty();
// }

// function showEditForm(contactId) {
//     // clear errorMessages
//     $('#errorMessages').empty();
//     // get the contact details from the server and then fill and show the
//     // form on success
//     $.ajax({
//         type: 'GET',
//         url: 'http://localhost:8080/contact/' + contactId,
//         success: function(data, status) {
//               $('#edit-first-name').val(data.firstName);
//               $('#edit-last-name').val(data.lastName);
//               $('#edit-company').val(data.company);
//               $('#edit-email').val(data.email);
//               $('#edit-phone').val(data.phone);
//               $('#edit-contact-id').val(data.contactId);
//           },
//           error: function() {
//             $('#errorMessages')
//                .append($('<li>')
//                .attr({class: 'list-group-item list-group-item-danger'})
//                .text('Error calling web service.  Please try again later.'));
//           }
//     });
//     $('#contactTableDiv').hide();
//     $('#editFormDiv').show();
// }

// function hideEditForm() {
//     // clear errorMessages
//     $('#errorMessages').empty();
//     // clear the form and then hide it
//     $('#edit-first-name').val('');
//     $('#edit-last-name').val('');
//     $('#edit-company').val('');
//     $('#edit-phone').val('');
//     $('#edit-email').val('');
//     $('#editFormDiv').hide();
//     $('#contactTableDiv').show();
// }

// function deleteContact(contactId) {
//     $.ajax ({
//         type: 'DELETE',
//         url: "http://localhost:8080/contact/" + contactId,
//         success: function (status) {
//             loadContacts();
//         }
//     });
// }

// // processes validation errors for the given input.  returns true if there
// // are validation errors, false otherwise
// function checkAndDisplayValidationErrors(input) {
//     // clear displayed error message if there are any
//     $('#errorMessages').empty();
//     // check for HTML5 validation errors and process/display appropriately
//     // a place to hold error messages
//     var errorMessages = [];

//     // loop through each input and check for validation errors
//     input.each(function() {
//         // Use the HTML5 validation API to find the validation errors
//         if(!this.validity.valid)
//         {
//             var errorField = $('label[for='+this.id+']').text();
//             errorMessages.push(errorField + ' ' + this.validationMessage);
//         }
//     });

//     // put any error messages in the errorMessages div
//     if (errorMessages.length > 0){
//         $.each(errorMessages,function(index,message){
//             $('#errorMessages').append($('<li>').attr({class: 'list-group-item list-group-item-danger'}).text(message));
//         });
//         // return true, indicating that there were errors
//         return true;
//     } else {
//         // return false, indicating that there were no errors
//         return false;
//     }
// }
