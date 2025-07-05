<script>
export default {
    data() {
        return {
            name: '',
            email: '',
        }
    },
    methods: {
        isValidGmail() {
            const gmailRegex = /^[a-zA-Z0-9._+]+@gmail\.com$/;
            return gmailRegex.test(this.email);
        },
        register() {
            if (this.name === '' || this.email === '') {
                alert('Please fill in all the fields');
                return;
            }
            if(!this.isValidGmail()) {
                alert('Please enter a valid Gmail address');
                return;
            }
            fetch('http://localhost:8080/api/employee/add_employee', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    "name": this.name,
                    "email": this.email
                })
            })
                .then(response => response.text())
                .then(() => {
                    this.$router.push('/');
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        },
    }
}
</script>

<template>
    <div class="CenterStyle">
        <div class="CenterStyle break">
            <p>Employee Name</p>
            <input type="text" v-model="name">
        </div>
        <div class="CenterStyle break">
            <p>Employee Email</p>
            <input type="text" v-model="email">
        </div>
        <button class="btn" @click="register">Register</button>
    </div>
</template>

<style>
.CenterStyle {
    display: flex;
    flex-wrap: wrap;
}

p {
    margin-right: 10px;
}

.break {
    margin: 10px;
    flex-basis: 100%;
}

.btn {
    margin-top: 10px;
    margin-right: 10px;
    padding: 10px;
    border-radius: 5px;
    border: none;
    background-color: #4CAF50;
    color: white;
    cursor: pointer;
}
</style>