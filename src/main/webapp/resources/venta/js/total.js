$(document).ready(function () {

        var total = 0;
        $("#total").click(function () {
            var name = $("input[id='itemCode']")
                .map(function () {return $(this).val();}).get();
            var price = $("input[id='itemPrice']")
                .map(function () {return $(this).val();}).get();
            var quantity = $("input[id='itemQty']")
                .map(function () {return $(this).val();}).get();
            var products = '';
            var price_quantity = 0;
            for(var i = 0; i < name.length; i++) {
                price_quantity = price[i] * quantity[i];
                products = {
                    'name': name[i],
                    'price': price[i],
                    'quantity':quantity[i],
                    'total': price_quantity.toFixed(2)
                }
                console.log(products);

                total +=price[i] * quantity[i];

            }
            console.log('TOTAL');
            console.log(total.toFixed(2));

        });
    });
