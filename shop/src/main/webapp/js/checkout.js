/**
 * checkout.java 주문/결제
 */
function usePoint(obj, point, price){
   let pointElem = document.getElementById("point");
   let tot_amount = document.getElementById("cartTotPrice");
   let curPoint = document.getElementById("lbl");
   
   if(obj.checked){                     // 천단위 정규표현식
      pointElem.value = point.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
      
      tot_amount.innerText = (price-point).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+ '원';
      curPoint.innerText='전액사용 [0원]';
   }else{
      pointElem.value="";
      tot_amount.innerText = price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+ '원';
      curPoint.innerText='전액사용 ['+point.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+'원]';
   }
}

// 숫자만 입력
function removeChar(e){
            // console.log("입력ㅁㅇㄴㄹ")
            // console.log("keyCode : " + event.keycode);
            // console.log(event.target.value);

            e.target.value = e.target.value.replace(/[^0-9]/g, '');
        }

// 지불 방법 선택
function selPayment(){
   let payArr = document.getElementsByName("payment");
   
   for(let i = 0; i<payArr.length; i++){
      if(payArr[i].checked){
         document.getElementById(payArr[i].value).style.display="block";
      }else{
         document.getElementById(payArr[i].value).style.display="none";
      }
   }
}

/**
 * 
 */
function checkAll(){
	// 체크여부, isChecked == true or false
	let isChecked = document.getElementById("checkAll").ariaChecked;
	
	//  배열 chks 저장 
	let chks = document.getElementsByName("chk");
	
	for(let i = 0; i<chks.length; i++){
		chks[i].checked = isChecked;
	}
}

function pordDel(){
	let chks = document.getElementsByName("chk");
	
	let pnumStr = "";
	   let separator = false;
	   
	   // 체크된 상품번호가 3, 5, 7이면
	   // pnumStr = "3/5/7"
	   for(let i=0; i<chks.length; i++){
	      // 체크된것만 가져옴
	      if(chks[i].checked){
	         // if구문은 최초에는 실행안됨
	         if(separator){
	            pnumStr = pnumStr + "/";
	         }
	         pnumStr = pnumStr + chks[i].value;
	         separator = true;
	      }
	   }
	   // javascript에서는 ""값을 false 인식한다.
	   if(!pnumStr){
	      alert("삭제할 상품을 체크하세요!!");
	      return;
	   }
	   // <input type="hidden" name="delPnums"/>의 value 속성에 할당 
	   document.checkForm.delPnums.value=pnumStr;
	   
	   // 확인 버튼 클릭시 true를 리턴한다.
	   let res = confirm("삭제 하시겠습니다?");
	   
	   if(res){
	      document.checkForm.submit()   
	   }

}