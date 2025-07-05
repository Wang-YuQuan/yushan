<script>
export default {
    props: {
        SeatData: {
            type: Object,
            required: true
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
    <div v-if="SeatData.emp_id === 0" class="GrayCard CenterStyle">
        <p>{{ SeatData.floor_no }}樓: 座位{{ SeatData.seat_no }}</p>
    </div>
    <div v-else-if="SeatData.emp_id === 'pick'" class="GreenCard CenterStyle">
        <p>{{ SeatData.floor_no }}樓: 座位{{ SeatData.seat_no }} 異動中</p>
    </div>
    <div v-else class="RedCard CenterStyle">
        <p>{{ SeatData.floor_no }}樓: 座位{{ SeatData.seat_no }} [員編: {{ SeatData.emp_id }}]</p>
    </div>
</template>

<style>
.CenterStyle {
    display: flex;
    justify-content: center;
    align-items: center;
}

.RedCard {
    border-radius: 10px;
    width: 200px;
    height: 100px;
    margin: 20px;
    background-color: rgb(230, 105, 101);
}

.GreenCard {
    border-radius: 10px;
    width: 200px;
    height: 100px;
    margin: 20px;
    background-color: rgb(97, 238, 97);
}

.GrayCard {
    border-radius: 10px;
    width: 200px;
    height: 100px;
    margin: 20px;
    background-color: rgb(158, 174, 179);
}
</style>