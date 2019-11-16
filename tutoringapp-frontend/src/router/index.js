import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import tutoringApp from '@/components/tutoringApp'
import Course from '@/components/Course'

import Subject from '@/components/Subject'

import Tutor from '@/components/Tutor'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/app',
      name: 'tutoringApp',
      component: tutoringApp
    },
    {
      path: '/course',
      name: 'Course',
      component: Course
    },
    {

    path: '/subject',
    name: 'Subject',
    component: Subject
    },
    {
      path: '/tutor',
      name: 'Tutor',
      component: Tutor

    }
  ]

})
