const express = require("express");
const app = express();

const data = [];
app.use(express.json());

// Route to fetch student data by roll number
app.get('/orders', function (req, res) {
    res.status(200).send(data);
});

app.get("/orders/:id", function (req, res) {
    let found = data.find(function (item) {
        return item.id === parseInt(req.params.id);
    });
    if (found) {
        res.status(200).send(found);
    } else {
        res.status(404).send();
    }
});

app.post('/orders', function (req, res) {

    let items = data.map(item => item.id);

    let newId = items.length > 0 ? Math.max.apply(Math, items) + 1 : 1;

    let newItem = {
        id: newId,
        customerName: req.body.customerName,
        totalPrice: req.body.totalPrice,
    }

    data.push(newItem);

    res.status(201).send(newItem);
});
  

app.put('/orders/:id', function (req, res) {
    let found = data.find(function (item) {
        return item.id === parseInt(req.params.id);
    });
    if (found) {
        let updateData = {
            id: found.id,
            customerName: req.body.customerName,
            totalPrice: req.body.totalPrice,
        };

        let targetIndex = data.indexOf(found);

        data.splice(targetIndex, 1, updateData);

        res.status(200).send(updateData);
    } else {
        res.status(404).send();
    }
});
  

app.delete('/orders/:id', function (req, res) {
    let found = data.find(function (item) {
        return item.id === parseInt(req.params.id);
    });
    if (found) {
        let targetIndex = data.indexOf(found);

        data.splice(targetIndex, 1);

        res.status(200).send();
    } else {
        res.status(404).send();
    }
});

const PORT = 4000;
app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`);
});
