define(['jquery', 'underscore', 'backbone', 'collections/projects', 'text!templates/project/list.html', 'constants'], 
        function($, _, Backbone, ProjectsCollection, projectListTemplate, Constants) {

    var ProjectListView = Backbone.View.extend({
        el: $("#container"),
		
        initialize: function() {
            this.collection = new ProjectsCollection();
            this.collection.add({ name: "Harry Potter"});
            this.collection.add({ name: "Yo Yo Honey Singh"});
			Constants.VENT.bind('projects:click', this.random);
			_.bindAll(this, 'close', 'random');
		},
        
        render: function() {
            var compiledTemplate = _.template(projectListTemplate, { projects: this.collection.toJSON() } );
            this.$el.append(compiledTemplate);
        },
	
		events: {
			"click .close"	:	"close"
		},
	
		close: function() {
			this.undelegateEvents();
			this.$el.empty();
		},
		
		random: function() {
			alert('cald global vent !! ');
		}
    });
    
    return ProjectListView;
});