define([
  'jquery',
  'underscore',
  'backbone',
  'collections/projects',
  'text!templates/project/list.html'
], function($, _, Backbone, ProjectsCollection, projectListTemplate){
  var ProjectListView = Backbone.View.extend({
    el: $("#container"),
    initialize: function(){
      this.collection = new ProjectsCollection();
      this.collection.add({ name: "Ginger Kid"});
      this.collection.add({ name: "Yo Yo Honey Singh !"});
      // Compile the template using Underscores micro-templating
      console.log(this.collection.toJSON());
      var compiledTemplate = _.template(projectListTemplate, { projects: this.collection.toJSON() } );
      this.$el.html(compiledTemplate);
    }
  });
  // Returning instantiated views can be quite useful for having "state"
  return ProjectListView;
});