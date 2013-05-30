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
      // Compile the template using Underscores micro-templating
      alert(JSON.stringify(this.collection));
      var compiledTemplate = _.template(projectListTemplate, { projects: JSON.stringify(this.collection) } );
      this.$el.html(compiledTemplate);
    }
  });
  // Returning instantiated views can be quite useful for having "state"
  return ProjectListView;
});