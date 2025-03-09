function setRoomSession(roomType, price, roomNo) {
           sessionStorage.setItem("roomType", roomType);
           sessionStorage.setItem("roomPrice", price);
           sessionStorage.setItem("roomNo", roomNo);
       }