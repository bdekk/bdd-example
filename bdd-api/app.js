const fs = require('fs');
const express = require('express')
const bodyParser = require('body-parser')
const app = express()
const port = 3000

app.use(bodyParser.json());
app.listen(port, () => console.log(`Simple Rest api running on port ${port}!`))

app.get('/', (req, res) => res.send('Hello World!'))

app.post('/login', (req, res) => {
    console.log(req.body)
    const username = req.body.username
    const password = req.body.password
    data = get_data()

    // master password!
    if (username === 'master' && password === 'root') {
        return res.status(200).send()
    }

    let valid_credentials = data['accounts'].some(acc => {
        return acc.username === username && acc.password === password
    })
    
    if(valid_credentials) return res.status(200).send();
    res.status(403).send();
})

const get_data = () => {
    return JSON.parse(fs.readFileSync('data.json'));
}
