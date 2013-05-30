define(['jquery', 'underscore', 'backbone', 'constants'], function($, _, Backbone, Constants) {

    var HomeView = Backbone.View.extend({
        el: $("body"),
		
        initialize: function() {
			_.bindAll(this, 'close', 'home');
		},
	
		events: {
			"click #home"	:	"home",
			"click #projects"	:	"projects"
		},
	
		close: function() {
			this.undelegateEvents();
		},
		
		home: function() {
			alert('cald home view home method');
		},
		
		projects: function() {
			Constants.VENT.trigger('projects:click');
		}
    });
    
    return HomeView;
});