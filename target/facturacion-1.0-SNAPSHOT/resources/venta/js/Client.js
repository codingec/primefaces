$(document).ready(function () {
    var baseUrl = "http://" + "127.0.0.1" + ":" + "8000";


     $('input#username').keypress(function () {
        var tocken_validation = $('#validator_tocken').val();
         var userAt = $(this).val();
            $.ajax(baseUrl + "/administration/validate_custumer/", {
                data: {
                    username: userAt,
                    tocken: tocken_validation,
                },
                dataType: 'json'
            }).done(function (data) {

                if (data) {
                    $('#name').val(data.one);
                    $('#surname').val(data.two);
                    $('#email').val(data.six);
                    $('#Phonenumber').val(data.four);
                    $('#PlaceLive').val(data.five);
                    $('#validator').val(data.seven);

                }
            });


        });


});


