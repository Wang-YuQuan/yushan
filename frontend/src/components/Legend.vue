<script>
export default {
    props: {
        Sign: {
            type: String,
        }
    },
    data() {
        return {
            
        }
    },
    methods: {

    }
}
</script>

<template>
    <div v-if="Sign=='empty'" class="break LeftStyle">
        <div class="fig-gray"></div>
        <p class="">空位</p>
    </div>
    <div v-else-if="Sign=='full'" class="break LeftStyle">
        <div class="fig-red"></div>
        <p class="">已占用</p>
    </div>
    <div v-else class="break LeftStyle">
        <div class="fig-green"></div>
        <p class="">請選擇</p>
    </div>
</template>

<style>
.LeftStyle {
    display: flex;
    margin-right: auto;
    margin: 5px;
}

.fig-gray {
    width: 20px;
    height: 20px;
    border: 1px solid #000;
    background-color: rgb(158, 174, 179);
    margin-right: 5px;
}

.fig-green {
    width: 20px;
    height: 20px;
    border: 1px solid #000;
    background-color: rgb(97, 238, 97);
    margin-right: 5px;
}

.fig-red {
    width: 20px;
    height: 20px;
    border: 1px solid #000;
    background-color: rgb(230, 105, 101);
    margin-right: 5px;
}

.break {
    flex-basis: 100%;
}
</style>