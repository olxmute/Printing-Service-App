for (const elem of document.getElementsByClassName("pro-qty")) {
    for (const button of elem.getElementsByClassName("qtybtn")) {
        button.onclick = function () {
            const counterElem = elem.getElementsByClassName("add-to-cart-count")[0];
            const oldValue = parseInt(counterElem.value);
            if (button.classList.contains("inc")) {
                counterElem.value = oldValue + 1;
            } else {
                if (oldValue > 1) {
                    counterElem.value = oldValue - 1;
                } else {
                    counterElem.value = 1;
                }
            }
        }
    }
}