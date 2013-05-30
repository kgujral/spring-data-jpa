define([], function() {
    
    var utilFunctions =  {
        renderView : function(view) {
            if (this.currentView) {
                this.currentView.close();
            }
            this.currentView = view;
            this.currentView.render();
        }
    };
    
    return utilFunctions;
});