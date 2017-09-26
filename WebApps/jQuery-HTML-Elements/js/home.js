$(document).ready(function () {
    
    // Center all H1 elements
    $('h1').addClass('text-center');
    
    // Center all H2 elements
    $('h2').addClass('text-center');
    
    // ???Replace the class that is on the element containing the text “Team Up!” 
    // with the class page-header
    $('.myBannerHeading').addClass('page-header').removeClass('.myBannerHeading');
    $('.page-header').text('It Worked!');

    // Change the text of “The Squad” to “Yellow Team”
    $('#yellowHeading').text("Yellow Team");
    
    // Change the background color for each team list to match the name of the team
    $('#orangeTeamList').css('background-color', 'Orange');
    $('#blueTeamList').css('background-color', 'Blue');
    $('#redTeamList').css('background-color', 'Red');
    $('#yellowTeamList').css('background-color', 'Yellow');

    // Add Joseph Banks and Simon Jones to the Yellow Team list
    $('#yellowTeamList').append("<li>Jospeh Banks</li><li>Simon Jones</li>"); 

    // Hide the element containing the text “Hide Me!!!”
    $('#oops').find('h1').hide();

    // Remove the element containing the text “Bogus Contact Info” from the footer
    $('#footerPlaceholder').remove();

    // Add a paragraph element containing your name and email to the footer. 
    // The text must be in Courier font and be 24 pixels in height
    $('#footer').append("<p>Jeff Croyle<br>jeffcroyle36@yahoo.com</p>")
    .css('font-family', 'Courier').css('font-size', '24px');

});