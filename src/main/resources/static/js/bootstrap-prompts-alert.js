var base_lan,lan;
if($("#base_language_code").length >=1){
    base_lan = $("#base_language_code").val() ;
}
if($("#language_code").length >=1){
    lan = $("#language_code").val();
}



window._originalAlert = window.alert;
window.alert = function(text,title,time) {
    var bootStrapAlert = function() {
        if(! $.fn.modal.Constructor)
            return false;
        if($('#windowAlertModal').length == 1)
            return true;
        $('body').append(' \
            <div id="windowAlertModal" class="modal fade"> \
                <div class="modal-dialog modal-sm">\
                    <div class="modal-content">\
                        <div class="modal-header">\
                            <h4 class="modal-title">&nbsp;</h4>\
                        </div>\
                        <div class="modal-body">\
                            <p>One fine body&hellip;</p>\
                        </div>\
                        <div class="modal-footer">\
                            <button type="button" class="btn btn-primary btn-blue" data-dismiss="modal"></button>\
                        </div>\
                    </div>\
                </div>\
            </div> \
        ');
        return true;
    }
    if ( bootStrapAlert() ){
        $('#windowAlertModal .modal-body').html(text);
        $('#windowAlertModal .modal-title').html(title);
        if(lan === "en" || base_lan === "2"){
            $('#windowAlertModal .modal-footer .btn-blue').html('Confirm');
        }else{
            $('#windowAlertModal .modal-footer .btn-blue').html('确认');
        }
        $('#windowAlertModal').modal();
        if(typeof time == "number"){
            clearTimeout(timer);
            var timer = setTimeout(function(){
                $('#windowAlertModal').modal('hide').remove();
                $(".modal-backdrop").remove();
            },time*1000)

        }
    }  else {
        console.log('bootstrap was not found');
        window._originalAlert(text);
    }
}

window._originalConfirm = window.confirm;
window.confirm = function (text, cb, title) {
    var initTemplate = function(){
      if($('#windowConfirmModal').length == 1)
        return true;
      $('body').append(' \
            <div id="windowConfirmModal" class="modal fade" data-backdrop="static" tabindex="-1" role="dialog" aria-hidden="true"> \
                <div class="modal-dialog modal-sm">\
                    <div class="modal-content">\
                        <div class="modal-header">\
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>\
                            <h4 class="modal-title">&nbsp;</h4>\
                        </div>\
                        <div class="modal-body">\
                            <p>One fine body&hellip;</p>\
                        </div>\
                        <div class="modal-footer">\
                            <button type="button" class="btn btn-primary btn-blue" data-dismiss="modal"></button>\
                            <button type="button" class="btn btn-primary btn-gray" data-dismiss="modal"></button>\
                        </div>\
                    </div>\
                </div>\
            </div> \
      ');
    }

    var bootStrapConfirm = function() {
      if(! $.fn.modal.Constructor)
          return false;

      $('body').off('click', '#windowConfirmModal .btn-blue');
      $('body').off('click', '#windowConfirmModal .btn-gray');

      function confirm() { cb(true); }
      function deny() { cb(false); }

      $('body').on('click', '#windowConfirmModal .btn-blue', confirm);
      $('body').on('click', '#windowConfirmModal .btn-gray', deny);

      return true;
    }

    initTemplate()

    if ( bootStrapConfirm() ){
        $('#windowConfirmModal .modal-body').html(text);
        $('#windowConfirmModal .modal-title').html('').html(title);
        if(lan === "en" || base_lan === "2"){
            $('#windowConfirmModal .modal-footer .btn-blue').html('OK');
            $('#windowConfirmModal .modal-footer .btn-gray').html('Cancel');
        }else{
            $('#windowConfirmModal .modal-footer .btn-blue').html('确定');
            $('#windowConfirmModal .modal-footer .btn-gray').html('取消');
        }
        $('#windowConfirmModal').modal();
    }  else {
        console.log('bootstrap was not found');
        cb(window._originalConfirm(text));
    }
}
