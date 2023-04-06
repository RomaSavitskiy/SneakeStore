function removeDiv() {
    var signInLink = document.getElementById("SignInLink");
    signInLink.remove();

    var signUpLink = document.getElementById("SignUpLink");
    signUpLink.remove();

    const parent = document.getElementById("myDiv");
    const child = document.createElement('a');
    child.href = '#';
    child.textContent = 'Sign out';
    child.style.cssText = 'height: 3rem;\n' +
        '    width: 100%;\n' +
        '\n' +
        '    font-weight: 500;\n' +
        '    font-size: 1.2rem;\n' +
        '    line-height: 3rem;\n' +
        '    color: black;\n' +
        '    text-decoration: none;\n' +
        '\n' +
        '    border: black solid 1px;\n' +
        '    border-radius: 1rem;\n' +
        '    display: block;\n' +
        '\n' +
        '    letter-spacing: -0.02em;';

    parent.appendChild(child);
}

function setDiscountStyle() {
    var priceText = document.getElementById("productId");
    priceText.style.color = "#9900FF";
}