//Dtos
function RoomDto (name, type, isAvailable, sessions) {
    this.name = name;
    this.type = type;
    this.isAvailable = isAvailable;
    this.sessions = sessions;
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
      //Test data
      const r1 = new RoomDto('TR5090', 'smallRoom', true, null);
      const r2 = new RoomDto('MC10', 'smallRoom', false, null);
      //Sample initial content
      this.rooms = [r1, r2];
  },

  methods: {
      createRoom: function (roomName, roomType) {
          // Create a new room and add it to the list of rooms
          var r = new RoomDto(roomName, roomType, true, null);
          this.rooms.push(r);
          // Reset the name and roomtype fields for new rooms
          this.newRoom = '';
      }
  }
}