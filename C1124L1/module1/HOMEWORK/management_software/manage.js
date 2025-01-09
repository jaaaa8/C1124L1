const products = [];
products.push("Sony Xperia");
products.push("Samsung Galaxy");
products.push("Nokia 6");
products.push("Xiaomi Redmi Note 4");
products.push("Apple iPhone 6S");
products.push("Xiaomi Mi 5s Plus");
products.push("Apple iPhone 8 Plus");
products.push("Fujitsu F-04E");
products.push("Oppo A71");

function displayProduct() {
    let tableData = '';
    for (let i = 0; i < products.length; i++) {
        tableData += `<tr>
        <td>${products[i]}</td>
        <td>
            <button onclick="editProduct(${i})">Edit</button>
        </td>
        <td>
            <button onclick="deleteProduct(${i})">Delete</button>
        </td>
    </tr>`;
    }
    document.getElementById("table").innerHTML = tableData;
    document.getElementById("totalProduct").innerHTML = products.length + " products";
}

displayProduct();

function addProduct() {
    products.push(document.getElementById("productName").value);
    document.getElementById("productName").value = '';
    displayProduct();
    Swal.fire({
        title: 'Thành công!',
        text: "Thêm sản phẩm thành công!",
        icon: 'success',
        confirmButtonText: 'OK'
    });
    banPhaoHoa();
}

function editProduct(i) {
    const productName = prompt("Nhập tên sản phẩm mới: ", products[i]);
    if (productName) {
        products[i] = productName;
        displayProduct();
        banPhaoHoa();
    }
}

function deleteProduct(i) {
    if (confirm("Bạn có muốn xóa sản phẩm " + products[i] + " không?")) {
        products.splice(i, 1);
        displayProduct();
        banPhaoHoa();
    }
}

function banPhaoHoa() {
    const duration = 15 * 1000,
        animationEnd = Date.now() + duration,
        defaults = { startVelocity: 30, spread: 360, ticks: 60, zIndex: 0 };

    function randomInRange(min, max) {
        return Math.random() * (max - min) + min;
    }

    const interval = setInterval(function() {
        const timeLeft = animationEnd - Date.now();

        if (timeLeft <= 0) {
            return clearInterval(interval);
        }

        const particleCount = 50 * (timeLeft / duration);

        // since particles fall down, start a bit higher than random
        confetti(
            Object.assign({}, defaults, {
                particleCount,
                origin: { x: randomInRange(0.1, 0.3), y: Math.random() - 0.2 },
            })
        );
        confetti(
            Object.assign({}, defaults, {
                particleCount,
                origin: { x: randomInRange(0.7, 0.9), y: Math.random() - 0.2 },
            })
        );
    }, 250);
}