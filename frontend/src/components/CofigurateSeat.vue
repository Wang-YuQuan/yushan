<script>
import Seat from '../components/Seat.vue'
import Legend from '../components/Legend.vue';

export default {
	components: {
		Seat,
		Legend
	},
	data() {
		return {
			selectedSeat: null,
			selectedUser: null,
			tempSelectedStatus: {},
			tempSelectedIndex: null,
			SeatData: [],
			employeeInfo: []
		}
	},
	mounted() {
		this.refreashData();
	},
	updated() {

	},
	methods: {
		refreashData() {
			fetch('http://localhost:8080/api/seat/seatStatus', {
				method: 'get',
				headers: {
					'Content-Type': 'application/json'
				}
			})
				.then(response => response.json())
				.then(data => {
					this.SeatData = data;
				})
				.catch(error => {
					console.error('錯誤：', error);
				});
			fetch('http://localhost:8080/api/employee/no_seat', {
				method: 'get',
				headers: {
					'Content-Type': 'application/json'
				}
			})
				.then(response => response.json())
				.then(data => {
					this.employeeInfo = data;
				})
				.catch(error => {
					console.error('錯誤：', error);
				});
		},
		handleChange() {
			if (this.tempSelectedIndex !== null) {
				this.SeatData[this.tempSelectedIndex] = { ...this.tempSelectedStatus };
			}
			const newIndex = this.SeatData.findIndex(item => item.floor_seat_seq === this.selectedSeat);
			if (newIndex !== -1) {
				this.tempSelectedIndex = newIndex;
				this.tempSelectedStatus = { ...this.SeatData[newIndex] };
				this.SeatData[newIndex].emp_id = 'pick';
			}
		},
		submit() {
			if (this.selectedSeat === null || this.selectedUser === null) {
				alert("請選擇樓層位置與員工");
				return;
			}
			fetch('http://localhost:8080/api/employee/change_seat', {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify({
					"MODIFY_EMP_ID": this.selectedUser,
					"MODIFY_FLOOR_SEAT_SEQ": this.selectedSeat
				})
			})
				.then(response => response.text())
				.then(() => {
					this.refreashData();
					this.selectedSeat = null;
					this.selectedUser = null;
					this.tempSelectedStatus = { };
					this.tempSelectedIndex = null;
				})
				.catch(error => {
					console.error('Error:', error);
				});
		}
	}
}
</script>

<template>
	<div class="home">
		<div v-for="item in SeatData" :key="item">
			<Seat :SeatData="item"></Seat>
		</div>
	</div>
	<select v-model="selectedSeat" @change="handleChange">
		<option disabled value="0">請選擇</option>
		<option v-for="option in SeatData" :key="option.floor_seat_seq" :value="option.floor_seat_seq">
			{{ option.floor_no }}樓{{ option.seat_no }}號
		</option>
	</select>
	<select v-model="selectedUser">
		<option value="0">清空座位</option>
		<option v-for="option in employeeInfo" :key="option.emp_id" :value="option.emp_id">
			{{ option.emp_id }} {{ option.name }}
		</option>
	</select>
	<Legend Sign="empty"></Legend>
	<Legend Sign="full"></Legend>
	<Legend Sign="change"></Legend>
	<button @click="submit">送出</button>
</template>

<style>
#app {
	display: flex;
	flex-wrap: wrap;
}

.home {
	display: flex;
	flex-wrap: wrap;
}
</style>