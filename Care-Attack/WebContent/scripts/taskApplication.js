$(document).ready()
{
$(function(){
  var Event = Backbone.Model.extend();
  
  var Events = Backbone.Collections.extend({
                                           model: Event,
                                           url: 'events'
                                           });
  
  var EventsView = Backbone.View.extend({
                                        initialize: function(){
                                        _.bindAll(this);
                                        
                                        this.collection.bind('reset',this.addAll);
                                        },
                                        render: function(){
                                            this.el.fullCalendar({
                                                             header: {
                                                             left: 'prev,next today',
                                                             center: 'title',
                                                             right: 'month,basicWeek,basicDay',
                                                             ignoreTimeZone: false
                                                             },
                                                             selectable: true,
                                                             selectHelper: true,
                                                             editable: true,
                                                             select: this.select
                                                             });
                                        },
                                        addAll: function(){
                                        this.el.fullCalendar('addEventSource',this.collection.toJSON());
                                        }
                                        select: function(startDate,endDate){
                                        new EventView().render();
                                        },
                                        });
  var EventView = Backbone.View.extend({
                                       el:$("#eventDialog"),
                                       initialize: function(){
                                       _.bindAll(this);
                                       },
                                       render: function(){
                                       this.el.dialog({
                                                      modal: true,
                                                      title: "New Event",
                                                      buttons: {"Cancel": this.close}
                                                      });
                                       return this;
                                       },
                                       close: function(){
                                       this.el.dialog('close');
									   }
                                       });
  var events = new Events();
  new EventsView({el: $("#calendar"),collection:events}).render();
  events.fetch();
  });
};