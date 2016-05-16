var gulp = require('gulp');
var clean = require('gulp-clean');
var concat = require('gulp-concat');

var bases = {
    dist: 'src/main/resources/static/js/dist/'
};

var paths = {
    scripts: ['src/main/resources/static/js/app/**.js', 'src/main/resources/static/js/app/**/*.js']
};


gulp.task('clean', function () {
    return gulp.src(bases.dist + '**.js').pipe(clean());
});

gulp.task('concat', ['clean'], function () {;
    return gulp.src(paths.scripts)
        .pipe(concat('app.js'))
        .pipe(gulp.dest(bases.dist));
});