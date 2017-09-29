$(document).ready(function () {
  loadContacts();

  $('#add-button').click(function (event){

    $.ajax({
      type: 'POST',
      url:'http://localhost:8080/contact',
      data: JSON.stringify({
        firstName: $('#add-first-name').val(),
        lastName: $('#add-last-name').val(),
        company: $('#add-company').val(),
        phone: $('#add-phone').val(),
        email: $('#add-email').val()
      }),
      headers: {
        'Accept' : 'application/json',
        'Content-Type' : 'application/json'
      },
      'dataType' : 'json',
      success: function() {
        $('#errorMessages').empty();
        $('#add-first-name').val('');
        $('#add-last-name').val('');
        $('#add-company').val('');
        $('#add-phone').val('');
        $('#add-email').val('');
        loadContacts();
      },
      error: function () {
        $('#errorMessages')
        .append($('<li>')
        .attr({class: 'list-group-item list-group-item-danger'})
        .text('Error calling web service. Please try again later.'));
      }
    })

  });

});

function loadContacts() {
  clearContactTable();
  var contentRows = $('#contentRows');

  $.ajax({
    type: 'GET',
    url: 'http://localhost:8080/contacts',
    success: function(contactArray) {
      $.each(contactArray, function(indx, contac) {
        var name = contac.firstName + ' ' + contac.lastName;
        var company = contac.company;

        var row = '<tr>';
            row += '<td>' + name + '</td>';
            row += '<td>' + company + '</td>';
            row += '<td><a onclick = "showEditForm()">Edit</a></td>';
            row += '<td><a>Delete</a></td>';
            row += '</tr>';

        contentRows.append(row);

      });
    },
    error: function() {
      $('#errorMessages')
        .append('<li>')
        .attr({class: 'list-group-item list-group-item-danger'})
        .text('Error calling web service. Please try again later.');
    }
  });
}

function clearContactTable() {
  $('#contentRows').empty();
}

function showEditForm() {
  $('#errorMessages').empty();

  $('#contactTableDiv').hide();
  $('#editFormDiv').show();
}

function hideEditForm() {
  $('#errorMessages').empty();

  $('#edit-first-name').val('');
  $('#edit-last-name').val('');
  $('#edit-company').val('');
  $('#edit-phone').val('');
  $('#edit-email').val('');

  $('#editFormDiv').hide();
  $('#contactTableDiv').show();
}
