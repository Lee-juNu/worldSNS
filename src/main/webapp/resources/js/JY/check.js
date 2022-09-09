// worldsns check


function joinCheck1() {
	var emailInput = document.joinForm1.join_email;


	if (isEmpty(emailInput)) {
		
		alert("이메일은 필수 입력 항목입니다");
		emailInput.value = "";
		emailInput.focus();
		
		return false;
		
	} 
	
	return true;
}


function joinCheck2() {
	var nickNameInput = document.joinForm2.join_nickName;
	var nameInput = document.joinForm2.join_name;
	var phoneNumberInput = document.joinForm2.join_phoneNumber;

	if (isEmpty(nickNameInput)) {
		
		alert("닉네임은 필수 입력 항목입니다.");
		nickNameInput.value = "";
		nickNameInput.focus();
		
		return false;
		
	} else if(isEmpty(nameInput)){
		alert("이름은 필수 입력 항목입니다.");
		nameInput.value = "";
		nameInput.focus();
		
		return false;
		
		
	}else if(isEmpty(phoneNumberInput) ||isNotNumber(phoneNumberInput)|| lessThan(phoneNumberInput,10) || moreThan(phoneNumberInput,11)){
		alert("띄어쓰기 없이 10~11자 사이의 휴대폰 번호를 입력해 주세요.");
		phoneNumberInput.value = "";
		phoneNumberInput.focus();
		
		return false;
	}
	
	
	return true;
}


function joinCheck3() {
	var idInput = document.joinForm3.join_ID;


	if (isEmpty(idInput)) {
		
		alert("필수 입력 항목으로, 중복되지 않는 아이디를 사용해 주세요.");
		idInput.value = "";
		idInput.focus();
		
		return false;
		
	} 
	
	return true;
}


function joinCheck4() {
	var pwInput = document.joinForm4.join_ID;


	if (isEmpty(pwInput) ||isEmpty(pwInput2) || 
	notContains(pwInput, "1234567890")|| notEquals(pwInput, pwInput2)) {
		
		alert("위의 비밀번호와 같은 비밀번호를 한 번 더 입력해 주세요.");
		idInput.value = "";
		idInput.focus();
		
		return false;
		
	} 
	
	return true;
}

