define(['jquery', 'underscore', 'backbone', 'collections/projects', 'text!templates/project/list.html'], 
        function($, _, Backbone, ProjectsCollection, projectListTemplate) {

    var ProjectListView = Backbone.View.extend({
        el: $("#container"),
        
        initialize: function() {
            this.collection = new ProjectsCollection();
            this.collection.add({ name: "Harry Potter"});
            this.collection.add({ name: "Yo Yo Honey Singh"});
        },
        
        render: function() {
            var compiledTemplate = _.template(projectListTemplate, { projects: this.collection.toJSON() } );
            this.$el.html(compiledTemplate);
        }
    });
    
    return ProjectListView;
});