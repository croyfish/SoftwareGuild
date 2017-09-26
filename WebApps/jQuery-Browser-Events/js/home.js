$(document).ready(function () {
    
//         Only the content in the Main section should display when the page is loaded.    
    $('#akronInfoDiv').hide();
    $('#minneapolisInfoDiv').hide();
    $('#louisvilleInfoDiv').hide();
    $('#akronWeatherButton').text("Show/Hide Weather");
    $('#minneapolisWeatherButton').text("Show/Hide Weather");
    $('#louisvilleWeatherButton').text("Show/Hide Weather");

//         When the Akron button is clicked, only the content in the Akron section 
//         should display; the weather information for Akron should be hidden initially.
    $('#akronButton').on('click', function() {
        $('#mainInfoDiv').hide();
        $('#minneapolisInfoDiv').hide();
        $('#louisvilleInfoDiv').hide();
        $('#akronInfoDiv').show();
        $('#akronWeather').hide();
    });

//         When the Minneapolis button is clicked, only the content in the Minneapolis 
//         section should display; the weather information for Minneapolis should be 
//         hidden initially.
$('#minneapolisButton').on('click', function() {
    $('#mainInfoDiv').hide();
    $('#akronInfoDiv').hide();
    $('#louisvilleInfoDiv').hide();
    $('#minneapolisInfoDiv').show();
    $('#minneapolisWeather').hide();
    });

//         When the Louisville button is clicked, only the content in the Louisville 
//         section should display; the weather information for Louisville should be 
//         hidden initially.
$('#louisvilleButton').on('click', function() {
    $('#mainInfoDiv').hide();
    $('#akronInfoDiv').hide();
    $('#minneapolisInfoDiv').hide();
    $('#louisvilleInfoDiv').show();
    $('#louisvilleWeather').hide();
    });

//     Show/Hide Weather Behavior
//         When the Show/Hide Weather button is clicked, the page should display the 
//         associated weather information if it was hidden or hide the associated weather 
//         information if it was showing. It should default to hidden.
$('#akronWeatherButton').on('click', function() {
    $('#akronWeather').toggle();
});

$('#minneapolisWeatherButton').on('click', function() {
    $('#minneapolisWeather').toggle();
});

$('#louisvilleWeatherButton').on('click', function() {
    $('#louisvilleWeather').toggle();
});

//         The background color of any table row should change to “WhiteSmoke” when the 
//         mouse pointer is hovering over the row.
//         This applies to all rows in all tables except the first (header) row in a given 
//         table. The first (header) row in any table should not change appearance when 
//         the mouse pointer hovers over it.
$('tr:not(:first)').hover(
    // in callback 
    function() {
    $(this).css('background-color', 'WhiteSmoke');
    },

//         The background color of the row should return to white when the mouse pointer 
//         is no longer hovering over the row.
    // out callback
    function() {
    $(this).css('background-color', '');
    }
);


// Desired Behavior

// Completed Behavior

// Upon successful completion of this exercise, the supplied HTML page will appear 
// to be four separate views to a user that display when the associated main navigation 
// buttons are clicked. The Akron, Minneapolis, and Louisville ‘views’ each have a 
// section for the weather in that city. The Show/Hide Weather button shows and hides 
// the weather for a given city as described in the requirements. Finally, the Akron, 
// Minneapolis, and Louisville ‘views’ each contain a table, when you are done with 
// the assignment, the non-header rows of these tables will be highlighted when the
//  mouse pointer hovers over them as described in the requirements.

// All table rows (except the header row) must display with the "WhiteSmoke" 
// background color when the mouse is hovering over them.

});