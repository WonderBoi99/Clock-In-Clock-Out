<template>
    <div class="loginpage">
        <div>
            <p class="sub-title">Please Enter Pin:</p>
            <input id="pin" name="pin" type="text" v-model="enteredPin"/>
        </div>
        <div class="pin-layout">
            <base-button v-for="dig in digits" :key="dig" @click="updateEnteredPin(dig)"><p class="large-text">{{dig}}</p></base-button>            
        </div>
        <div>
            <base-button @click="clearEnteredPin"><p class="medium-text">Clear Pin</p></base-button>            
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            enteredPin: '',
            digits: [1,2,3,4,5,6,7,8,9]
        };
    },
    methods:{
        updateEnteredPin(digit){
            if (this.enteredPin.length !== 4){
                this.enteredPin += digit;
            }
        },
        clearEnteredPin(){
            this.enteredPin = '';
        },
    },
    watch:{
        enteredPin(value){
            if (value.length === 4){
                //check if key is linked to user
                //if user key is correct & clocked in, collect time clocked in and username, redirect to main page for option for clocking out
                //if user key is correct & not clocked in, collect username, redirect to main page for option for clocking in
                //if in-valid key, clear pin and invalid message
                this.$router.push('/main/Nikhil/false');
            }
        }
    }
}
</script>

<style scoped>
.loginpage {
  text-align: center; /* Horizontally center the content */
  display: flex;
  flex-direction: column;
  align-items: center; /* Vertically center the content */
  height: auto; /* Set the height to 100% of the viewport height for vertical centering */
  justify-content: center; /* Center content both horizontally and vertically */
  background-color: white;
  margin-left: 25%;
  margin-right: 25%;
  border-radius: 0%;
  border: 5px solid black;
  padding: 50px;
}

.pin-layout{
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    width: 45%;
    margin: 3%
}

.large-text {
    font-size: 25px;
    font-weight: bold;
}

.sub-title {
    font-size: 35px;
    font-weight: bold;
    margin-top: 0%;
    margin-bottom: 3%;
}

.medium-text {
    font-size: 20px;
    font-weight: bold;
}

input{
    font-size: 35px;
    text-align: center;
}

</style>