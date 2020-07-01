function orderConstant() {
    submitRequest('inputOrderConstant', 'orderConstant', 'resultOrderConstant');
}

function orderLinear() {
    submitRequest('inputOrderLinear', 'orderLinear', 'resultOrderLinear');
}

function orderLogarithmic() {
    submitRequest('inputOrderLogarithmic', 'orderLogarithmic', 'resultOrderLogarithmic');
}

function submitRequest(inputId, path, resultId) {
    let data = document.getElementById(inputId).value;
    jQuery.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/algorithm_complexity/" + path,
        data: data,
        success: function (result) {
            document.getElementById(resultId).innerHTML = result.time;
        },
        error: function () {
            return "error";
        }
    });
}
