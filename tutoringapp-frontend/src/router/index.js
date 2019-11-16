import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import tutoringApp from '@/components/tutoringApp'
import Course from '@/components/Course'
import Tutor from '@/components/Tutor'
import Evaluation from '@/components/Evaluation'
import Room from '@/components/Room'
import Subject from '@/components/Subject2'

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
      path: '/tutor',
      name: 'Tutor',
      component: Tutor
    },
    {
      path: '/evaluation',
      name: 'Evaluation',
      component: Evaluation
    },
    {
      path: '/subject',
      name: 'Subject',
      component: Subject
    },
    {
      path: '/room',
      name: 'Room',
      component: Room
    }
  ]
})
