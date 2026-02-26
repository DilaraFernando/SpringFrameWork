// --- දත්ත ලබා ගැනීම (Data Initialization) ---
let customers = JSON.parse(localStorage.getItem('pos_customers')) || [];
let items = JSON.parse(localStorage.getItem('pos_items')) || [];
let cart = [];
let editingId = null;

// --- SMART DASHBOARD LOGIC ---
function updateDashboard() {
    const dashTotalCust = document.getElementById('dashTotalCust');
    if (dashTotalCust) { dashTotalCust.innerText = customers.length; }

    const dashTotalItems = document.getElementById('dashTotalItems');
    if (dashTotalItems) { dashTotalItems.innerText = items.length; }

    const dashTotalRevenue = document.getElementById('dashTotalRevenue');
    if (dashTotalRevenue) {
        let totalVal = items.reduce((acc, curr) => acc + (curr.price * curr.qty), 0);
        dashTotalRevenue.innerText = `Rs. ${totalVal.toLocaleString()}`;
    }

    const dashLowStock = document.getElementById('dashLowStock');
    if (dashLowStock) {
        const lowCount = items.filter(i => i.qty < 10).length;
        dashLowStock.innerText = lowCount;
    }
}

// --- COMMON FUNCTIONS ---
function deleteData(id, type) {
    if(!confirm("Are you sure you want to delete this?")) return;

    if(type === 'customer') {
        customers = customers.filter(c => c.id != id);
        localStorage.setItem('pos_customers', JSON.stringify(customers));
    } else {
        items = items.filter(i => i.id != id);
        localStorage.setItem('pos_items', JSON.stringify(items));
    }
    location.reload();
}

function editData(id, type) {
    editingId = id;
    if(type === 'customer') {
        let c = customers.find(c => c.id == id);
        document.getElementById('cId').value = c.id; // ID eka fill karanawa
        document.getElementById('cName').value = c.name;
        document.getElementById('cTel').value = c.tel;
    } else {
        let i = items.find(i => i.id == id);
        document.getElementById('iId').value = i.id; // ID eka fill karanawa
        document.getElementById('iName').value = i.name;
        document.getElementById('iPrice').value = i.price;
        document.getElementById('iQty').value = i.qty;
    }
}

// --- CUSTOMER FUNCTIONS ---
function saveCustomer() {
    const id = document.getElementById('cId').value; // Manual ID
    const name = document.getElementById('cName').value;
    const tel = document.getElementById('cTel').value;
    if(!id || !name || !tel) return alert("Please fill all fields!");

    let index = customers.findIndex(c => c.id == id);
    if(index !== -1) {
        customers[index] = { id, name, tel }; // Update existing
    } else {
        customers.push({ id, name, tel }); // Add new
    }

    localStorage.setItem('pos_customers', JSON.stringify(customers));
    alert("Customer data saved!");
    location.reload();
}

// --- ITEM FUNCTIONS ---
function saveItem() {
    const id = document.getElementById('iId').value; // Manual ID
    const name = document.getElementById('iName').value;
    const price = parseFloat(document.getElementById('iPrice').value);
    const qty = parseInt(document.getElementById('iQty').value);
    if(!id || !name || isNaN(price)) return alert("Invalid item data!");

    let index = items.findIndex(i => i.id == id);
    if(index !== -1) {
        items[index] = { id, name, price, qty };
    } else {
        items.push({ id, name, price, qty });
    }

    localStorage.setItem('pos_items', JSON.stringify(items));
    alert("Item data saved!");
    location.reload();
}

// --- PLACE ORDER FUNCTIONS ---
function initOrderPage() {
    const itemSelect = document.getElementById('itemSelect');
    if (itemSelect) {
        items.forEach(item => {
            itemSelect.innerHTML += `<option value="${item.id}">${item.name} (Rs. ${item.price})</option>`;
        });
    }
}

function addToCart() {
    const itemId = document.getElementById('itemSelect').value;
    const buyQty = parseInt(document.getElementById('buyQty').value);
    const item = items.find(i => i.id == itemId);

    if(!item || isNaN(buyQty) || buyQty <= 0) return alert("Please select item and quantity!");

    // Cart ekatath item ID eka add kala
    cart.push({ id: item.id, name: item.name, price: item.price, qty: buyQty, total: item.price * buyQty });
    renderCart();
}

function renderCart() {
    const body = document.getElementById('cartBody');
    let grandTotal = 0;
    if (body) {
        body.innerHTML = '';
        cart.forEach(c => {
            grandTotal += c.total;
            body.innerHTML += `<tr><td>${c.id}</td><td>${c.name}</td><td>${c.qty}</td><td>Rs. ${c.total.toFixed(2)}</td></tr>`;
        });
        document.getElementById('gTotal').innerText = `Rs. ${grandTotal.toFixed(2)}`;
    }
}

// --- PAGE INITIALIZATION ---
window.onload = () => {
    updateDashboard();

    const custTable = document.getElementById('custTable');
    if(custTable) {
        custTable.innerHTML = customers.map(c => `
            <tr>
                <td>${c.id}</td> <td>${c.name}</td>
                <td>${c.tel}</td>
                <td>
                    <button class="btn-edit" onclick="editData('${c.id}', 'customer')">Edit</button>
                    <button class="btn-delete" onclick="deleteData('${c.id}', 'customer')">Delete</button>
                </td>
            </tr>`).join('');
    }

    const itemTable = document.getElementById('itemTable');
    if(itemTable) {
        itemTable.innerHTML = items.map(i => `
            <tr>
                <td>${i.id}</td> <td>${i.name}</td>
                <td>Rs. ${i.price}</td>
                <td>${i.qty}</td>
                <td>
                    <button class="btn-edit" onclick="editData('${i.id}', 'item')">Edit</button>
                    <button class="btn-delete" onclick="deleteData('${i.id}', 'item')">Delete</button>
                </td>
            </tr>`).join('');
    }

    initOrderPage();
};