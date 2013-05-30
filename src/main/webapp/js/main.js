require.config({
    urlArgs: "ver=" + (new Date()).getTime(),       //just for dev purposes to eliminate caching of files.
    paths: {
        jquery: 'libs/jquery-1.8.3',
        underscore: 'libs/underscore-1.4.4-min',
        backbone: 'libs/backbone-0.9.9-min'
    },
    shim: {
        'backbone': {
            deps: ['underscore', 'jquery'],
            exports: 'Backbone'
        },
        'underscore': {
            exports: '_'
        },
    }
});

require(['app'], function(App) {
    App.initialize();
});