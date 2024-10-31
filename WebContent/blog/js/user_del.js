function toggleButton() {
            const checkbox = document.getElementById('one');
            const button = document.getElementById('del_btn');

            // 체크박스가 체크되었는지 확인
            if (checkbox.checked) {
                button.disabled = false; // 체크되면 버튼 활성화
            } else {
                button.disabled = true; // 체크 해제되면 버튼 비활성화
            }
        }