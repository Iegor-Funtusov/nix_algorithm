let modalData;
let modalDataType;

document.getElementById("modalOrderConstant").addEventListener("click", setModalDataTypeConstant);
document.getElementById("modalOrderLinear").addEventListener("click", setModalDataTypeLinear);
document.getElementById("modalOrderLogarithmic").addEventListener("click", setModalDataTypeLogarithmic);
document.getElementById("modalOrderLinearLogarithmic").addEventListener("click", setModalDataTypeLinearLogarithmic);

function setModalDataTypeConstant() {
    modalDataType = 'modalOrderConstant';
    loadModalData();
    initModalData();
}

function setModalDataTypeLinear() {
    modalDataType = 'modalOrderLinear';
    loadModalData();
    initModalData();
}

function setModalDataTypeLogarithmic() {
    modalDataType = 'modalOrderLogarithmic';
    loadModalData();
    initModalData();
}

function setModalDataTypeLinearLogarithmic() {
    modalDataType = 'modalOrderLinearLogarithmic';
    loadModalData();
    initModalData();
}

function runAlgorithmComplexity() {
    if (modalDataType) {
        switch (modalDataType) {
            case 'modalOrderConstant' : {
                submitRequest('orderConstant');
            } break;
            case 'modalOrderLinear' : {
                submitRequest('orderLinear');
            } break;
            case 'modalOrderLogarithmic' : {
                submitRequest('orderLogarithmic');
            } break;
            case 'modalOrderLinearLogarithmic' : {
                submitRequest('orderLinearLogarithmic');
            } break;
        }
    }
}

function submitRequest(path) {
    let data = document.getElementById('inputOrder').value;
    jQuery.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/algorithm_complexity/" + path,
        data: data,
        success: function (result) {
            document.getElementById('resultOrder').value = result.time;
        },
        error: function () {
            return "error";
        }
    });
}

function loadModalData() {
    if (!modalData) {
        $.getJSON('/json/algorithm_complexity_data_modal.json', function (data) {
            modalData = data;
            initModalData();
        });
    }
}

function initModalData() {
    if (modalData) {
        let data = modalData.data;
        let exampleModalLabel = document.getElementById('exampleModalLabel');
        let modalBodyId = document.getElementById('modalBodyId');
        switch (modalDataType) {
            case 'modalOrderConstant' : {
                exampleModalLabel.innerHTML = data.orderConstant.modalTitle;
                modalBodyId.innerHTML = data.orderConstant.modalBody;
            } break;
            case 'modalOrderLinear' : {
                exampleModalLabel.innerHTML = data.orderLinear.modalTitle;
                modalBodyId.innerHTML = data.orderLinear.modalBody;
            } break;
            case 'modalOrderLogarithmic' : {
                exampleModalLabel.innerHTML = data.orderLogarithmic.modalTitle;
                modalBodyId.innerHTML = data.orderLogarithmic.modalBody;
            } break;
            case 'modalOrderLinearLogarithmic' : {
                exampleModalLabel.innerHTML = data.orderLinearLogarithmic.modalTitle;
                modalBodyId.innerHTML = data.orderLinearLogarithmic.modalBody;
            } break;
        }
    }
}
