/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    //assuming on click should go here, ready from the outset

    //var selectedRole;
    loadRoles();
    $(".roleLink").on("click", function () {
        var roleId = $(this).data("id");
        console.log(roleId);
        showEditDetails(roleId); //not sure on syntax here....
    });

    $("#cancel-edit-button").on("click", function () {
        $('#editRole').hide();

    });

    $("#edit-button").on("click", function () {
        var idToUpdate = $('#hidden-id').val();
        console.log("Below is the Id to update from the edit button: ");
        console.log(idToUpdate);

        $.ajax({
            type: 'PUT',
            url: 'http://localhost:8080/BessieBlog/roles/' + idToUpdate,
            data: JSON.stringify({
                roleId: idToUpdate,
                name: $('#edit-name').val(),
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            success: function () {
                $('#editRole').hide();
//          $('#errorMessages').empty();
//          hideEditForm();
                loadRoles();
            },
            error: function () {
                console.log("Another fuck up.....");

            }

        })

    });
    $('#add-button').click(function (event) {
        //finds all inputs in form and check for validation errors

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/BessieBlog/roles/',
            data: JSON.stringify({
                name: $('#add-name').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            success: function () {

                $('#add-name').val('');

                loadRoles();
            },
            error: function () {
                console.log("whoops!");
            }
        })
    });
});



function showEditDetails(roleId) {
//  $('#errorMessages').empty();

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/BessieBlog/roles/' + roleId,
        success: function (data, status) {
            $('#edit-name').val(data.name); //.html
            $('#hidden-id').val(roleId);

        },
        error: function () {
//        $('#errorMessages')
//        .append($('<li>')
//        .attr({class: '<list-group-item list-group-item-danger'})
//        .text('Error calling web service. Please try again later.'));
            console.log("you fucked up");
        }
    })

//  $('#contactTableDiv').hide();
    $('#editRole').show();
}
;

function loadRoles() {
    clearRolesTable();
    var contentRows = $('#rolesTable');


    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/BessieBlog/roles/roleList',
        success: function (roleArray) {
            $.each(roleArray, function (index, role) {

                var name = role.name;
                var roleId = role.id;
                var row = '<tr>';
                row += '<td>' + name + '</td>';
                row += '<td><a onclick="showEditDetails(' + roleId + ')">Edit</a></td>';
                row += '<td><a onclick="deleteRole(' + roleId + ')">Delete</a></td>';
                row += '</tr>'

                contentRows.append(row);

                console.log("You did it!");
            });
        },
        error: function () {
            console.log("hello");


        }

    });
}
function clearRolesTable() {
    $('#rolesTable').empty();
}
function deleteRole(roleId) {

    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/BessieBlog/roles/' + roleId,
        success: function () {
            loadRoles();
        }
    });

}