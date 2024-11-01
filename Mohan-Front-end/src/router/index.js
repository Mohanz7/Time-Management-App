import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import aaa from '@/components/mohan'
import Kuakua from '@/components/Kuakua'
import b from '@/views/mohan'
import LoginDemoByMrWang from '@/components/LoginDemoByMr.Wang'
import Login from '@/components/Login'
import MainPageTry from '@/components/MainPageTry'
import MainPage from '@/views/MainPage'

Vue.use(Router)

export default new Router({
    routes: [{
            path: '/',
            name: 'HelloWorld',
            component: HelloWorld
        },

        {
            path: '/aaa',
            name: 'aaa',
            component: aaa
        },

        {
            path: '/Kuakua',
            name: 'Kuakua',
            component: Kuakua
        },

        {
            path: '/b',
            name: 'b',
            component: b
        },
        {
            path: '/LoginDemoByMrWang',
            name: 'LoginDemoByMrWang',
            component: LoginDemoByMrWang
        },
        {
            path: '/Login',
            name: 'Login',
            component: Login
        },
 
        {
            path: '/MainPageTry',
            name: 'MainPageTry',
            component: MainPageTry
        },
        {
            path: '/MainPage',
            name: 'MainPage',
            component: MainPage
        },


    ]
})