# Scala React Native
This [template](https://github.com/Nojipiz/ScalaReactNative) sets up a simple React Native application written in Scala through [Scala.js](https://www.scala-js.org), [Slinky](https://slinky.dev), and [Expo](https://expo.io), it's higly inspired in this [template](https://github.com/shadaj/expo-template-scala)


## Building Apps
Once you've created your project, first install npm dependencies with:
```
npm i 
```

then compile your Scala code to JavaScript by running
```
$ sbt fastOptJS
```

Then, launch the app with Expo
```
$ npm start
```

## Production Bundles
To create a minified app, first build an optimized Scala.js bundle
```
$ sbt fullOptJS
```

Then, go to `App.js` and uncomment `module.exports = require("./target/scala-2.13/scalareactnative-opt.js").app;` in order to enable the production bundle. Finally, switch Expo to production mode to load your production app.

## Ejecting
If you need to develop your app without depending on Expo, you can eject at any time by running `npm run eject`. This gives you the option to either eject to a "bare" project that uses React Native's build tooling or to an unmanaged ExpoKit project that still uses Expo but lets you add in custom native dependencies.
