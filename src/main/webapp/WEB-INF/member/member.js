function go_save(dupCheck) {
    if ($('#id').val().length == 0) {
      alert("아이디를 입력하여 주세요.");
      $('#id').focus();
    } else if (!dupCheck) {
      alert("중복확인을 클릭하여 주세요.");
      $('#dup').focus();
    } else if ($('#pwd').val().length == 0) {
      alert("비밀번호를 입력해 주세요.");
      $('#pwd').focus();
    } else if ($('#pwd').val() != $('#pwdCheck').val()) {
      alert("비밀번호가 일치하지 않습니다.");
      $('#pwd').focus();
    } else if ($('#name').val().length == 0) {
      alert("이름을 입력해 주세요.");
      $('#name').focus();
    } else if ($('#email').val().length == 0) {
      alert("이메일을 입력해 주세요.");
      $('#email').val().focus();
    } else {
      $('#join').submit();
    }
  }

$(function(){
    var dupCheck=false;
    
    $("#next").on("click", function(){
        if ($("input:radio[id='okon1']").is(":checked")) {
            location.href="join.do";
        } else {
            alert('약관에 동의하셔야만 합니다.');
        }
    });
    
    $('#reg').on("click", function(){
        go_save(dupCheck);
    });
    
    $('#dup').on("click", function(){
        if ($('#id').val().length == 0) {
            alert('아이디를 입력하여 주십시오.');
            $('#id').focus();
            return;
        }
        var member = {id : $('#id').val()};
        $.get("idCheck.do", member, function(data){
            if (data == 1){
                alert("사용가능한 아이디");
                dupCheck = true;
            }else{
                alert("중복 아이디");
                $('#id').select();
                $('#id').focus();
            }
        });
    });
    
    $('#findZipNum').on("click", function(){
        window.open( "findZipNum.do", "_blank_1",
        "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=300, top=300, left=300, ");
    });
});
