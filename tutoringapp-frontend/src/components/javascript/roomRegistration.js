//Dtos
function RoomDto (name, type, isAvailable) {
    this.name = name;
    this.type = type;
    this.isAvailable = isAvailable;
    this.sessions = [];
}

export default {
    name: 'roomRegistration',
  data() {
    return {
        rooms: [],
        newRoom: '',
        errorRoom: '',
        response: []
    //   fields: [],
    //   items: []
    }
  },

  created: function () {
    //   //Test data
    //   const r1 = new RoomDto('TR5090', 'smallRoom');
    //   const r2 = new RoomDto('MC10', 'smallRoom');
    //   //Sample initial content
    //   this.rooms = [r1, r2];
  },

//   methods: {
//       createRoom: function (roomName, roomType) {
//           // Create a new room and add it to the list of rooms
//           var r = new RoomDto(roomName, roomType);
//           this.rooms.push(r);
//           // Reset the name and roomtype fields for new rooms
//           this.newRoom = '';
//       }
//  }
}