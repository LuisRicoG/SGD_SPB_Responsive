/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


document.addEventListener('DOMContentLoaded', function() {
    var initialLocaleCode = 'es';
    var Calendar = FullCalendar.Calendar;  

    /* initialize the calendar
    -----------------------------------------------------------------*/

    var calendarEl = document.getElementById('calendar');
    var calendar = new Calendar(calendarEl, {
      plugins: [ 'interaction', 'dayGrid', 'timeGrid', 'list' ],
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay,listYear'
      },
      aspectRatio: 2,
      locale: initialLocaleCode,
      timeZone: 'America/Mexico_City',
      buttonIcons: false, // show the prev/next text
      weekNumbers: true,
      navLinks: true, // can click day/week names to navigate views
      eventLimit: true, // allow "more" link when too many events      
      events: {
        url: '/SGD/plantrabajo/listaeventos',
        type: 'POST',
        error: function() {
          alert('there was an error while fetching events!');
        },
      }
    });
    
    calendar.render();

  });