var name = $('#name').val();
var desc = $('#description').val();

function validate() {
    var result = true;
    if (name == '') {
        result = false;
        alert('Please, enter your Item');
    }
    if (desc == '') {
        result = false;
        alert('Please, enter your Description');
    }
    return result;
}

function createItem() {
    alert(validate());
    if (validate() == true) {
        $.ajax({
            url: "/add",
            method: "POST",
            data: {
                item: name,
                desc: desc
            },
            complete: function(responce) {
                var result = JSON.parse(response.responseText);
                alert(result);
                location.reload();
            }
        });
    }
}

function fillItems() {
    $.ajax({
        url: "/items",
        method: "POST",
        complete: function (response) {
            alert(response);
            var items = JSON.parse(response.responseText);
            var result = "<thead>" +
                "<tr>" +
                "<th>ID</th>" +
                "<th>Item</th>" +
                "<th>Description</th>" +
                "<th>Created</th>" +
                "<th>Done</th>" +
                "</tr>" +
                "</thead>" +
                "<tbody>";
            for (var i = 0; i < items.length; i++) {
                var id = items[i].id;
                var description = items[i].description;
                var created = items[i].created;
                var status = items[i].status;
                result += "<tr><td>" + id + "</td><td>" + description + "</td><td>"
                    + created + "</td><td>" + status + "</td></tr>";
            }
            result += "</tbody>";
            $('#dynamic').html(result);
        }
    });
}
