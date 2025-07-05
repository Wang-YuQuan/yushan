import Layout from '@/components/Layout.vue'
import ConfigurateSeat from '../components/CofigurateSeat.vue'
import RegisterEmployee from '@/components/RegisterEmployee.vue'
import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
	history: createWebHistory(import.meta.env.BASE_URL),
	routes: [
		{
			path: '/',
			component: Layout,
			children: [
				{ path: '', redirect: 'configureSeat' },
				{ path: 'configureSeat', component: ConfigurateSeat },
			],
		},
		{
			path: '/registerEmployee',
			component: RegisterEmployee,
		},
	],
})

export default router
