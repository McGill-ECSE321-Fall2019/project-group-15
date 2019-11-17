// import axios from 'axios'
// var config = require('../../../config')

// var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
// var backendUrl = 'https://tutoringapp-15.herokuapp.com'

// var AXIOS = axios.create({
//   baseURL: backendUrl,
//   headers: { 'Access-Control-Allow-Origin': frontendUrl }
// })

// //Dtos
// // function RoomDto (name, type, isAvailable) {
// //     this.name = name;
// //     this.type = type;
// //     this.isAvailable = isAvailable;
// //     this.sessions = [];
// // }

// export default {
//     name: 'roomRegistration',
//     data() {
//     return {
//         rooms: [],
//         newRoom: '',
//         errorRoom: '',
//         response: []
//     //   fields: [],
//     //   items: []
//     }
//   },

//   created: function () {

//     //   //Test data
//     //   const r1 = new RoomDto('TR5090', 'smallRoom');
//     //   const r2 = new RoomDto('MC10', 'smallRoom');
//     //   //Sample initial content
//     //   this.rooms = [r1, r2];
//   },

// //   methods: {
// //       createRoom: function (roomName, roomType) {
// //           // Create a new room and add it to the list of rooms
// //           var r = new RoomDto(roomName, roomType);
// //           this.rooms.push(r);
// //           // Reset the name and roomtype fields for new rooms
// //           this.newRoom = '';
// //       }
// //  }
// }

      
//       AXIOS.get('/getAllRooms')
//     .then(response => {
//       this.rooms = response.data;
//       this.rooms.forEach(room => this.getRoom(room.name))
//     })
//     .catch(e => {this.errorRoom = e});

//   },

//   methods: {
//       createRoom: function (roomName, roomType) {
//           AXIOS.post(`/createRoom?roomName=` + roomName + `&roomType=` + roomType, {}, {})
//             .then(response => {
//             // JSON responses are automatically parsed.
//             this.rooms.push(response.data)
//             this.newRoom = ''
//             this.errorRoom = ''
//         })
//         .catch(e => {
//         var errorMsg = e.message
//         console.log(errorMsg)
//         this.errorRoom = errorMsg
//         });
//       }
//   },

// //   getRoom: function (roomName) {
// //       AXIOS.get('/getAllRooms)
// //       .then(response => {
// //         if (!response.data || response.data.length <= 0) return;

// //         let indexPart = this.persons.map(x => x.name).indexOf(personName);
// //         this.persons[indexPart].eventsAttended = [];
// //         response.data.forEach(event => {
// //           this.persons[indexPart].eventsAttended.push(event);
// //         });
// //       })
// //       .catch(e => {
// //         e = e.response.data.message ? e.response.data.message : e;
// //         console.log(e);
// //       });
// //     },

// }   

