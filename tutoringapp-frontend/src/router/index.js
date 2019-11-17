import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Student from '@/components/Student'
import Course from '@/components/Course'
import Tutor from '@/components/Tutor'
import Evaluation from '@/components/Evaluation'
import Room from '@/components/Room'
import Dashboard from '@/components/Dashboard'
import Subject from '@/components/Subject'



Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/student',
      name: 'Student',
      component: Student
    },
    {
      path: '/dashboard',
      name: 'Dashboard',
      component: Dashboard
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
      path: '/room',
      name: 'Room',
      component: Room
    },
    {
      path: '/subject',
      name: 'Subject',
      component: Subject
    }
  ]
})
