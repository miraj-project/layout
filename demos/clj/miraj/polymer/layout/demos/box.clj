(ns miraj.polymer.layout.demos.box
  (:require [miraj.core :as miraj]
            [miraj.html :as h]
            [miraj.polymer.layout :as layout]

            ;; for testing only:
            [miraj.compiler :as wc]
            [miraj.co-dom :as x]
            :reload))

(miraj/defpage ^{:miraj/demonstrates miraj.polymer.layout/box}
  document-scroll
  "Polymer App-Box Demo - document scroll."

  {:html/title "app-box demo using the document scroll"
   :html/description "This page demonstrates a Polymer app-box element."}

  (:require [miraj.polymer.layout :as app :refer [toolbar]])

  (:styles [[miraj.polymer.layout.extensions parallax]])

  (:css :custom "
    body {
      margin: 0;
      font-family: 'Roboto', 'Noto', sans-serif;
      background-color: #eee;
      scroll-behavior: smooth;
    }

    header {
      background-color: white;
      height: 128px;
    }

    app-toolbar {
      font-size: 18px;
      font-weight: 400;
      letter-spacing: 5px;
      text-align: center;
      color: #1a237e;
    }

    .nav {
      height: 64px;
      margin: 0;
      padding: 0;
      text-align: center;
      background-color: rgba(255, 255, 255, 0.8);
    }

    .nav li {
      display: inline-block;
      list-style: none;
    }

    .nav a {
      display: inline-block;
      font-weight: 12px;
      line-height: 64px;
      text-decoration: none;
      color: black;
      font-weight: 300;
      margin: 0 10px;
    }

    .nav a:hover {
      color: #444;
      border-bottom: 1px solid #999;
    }

    [threshold-triggered] {
      position: fixed;
      top: 0;
      left: 0;
      right: 0;
      z-index: 1;
      -webkit-backdrop-filter: saturate(180%) blur(20px);
      backdrop-filter: saturate(180%) blur(20px);
    }

    .first, .second, .third, .fourth {
      height: 640px;
    }

    .second {
      --app-box-background-front-layer: {
        background-image: url(//app-layout-assets.appspot.com/assets/bg2.jpg);
        background-position: bottom;
        padding-bottom: 120px;
        margin-top: -20px;
        height: 100%;
      };
    }

    .third {
      --app-box-background-front-layer: {
        background-image: url(//app-layout-assets.appspot.com/assets/bg3.jpg);
        background-position: bottom;
        padding-bottom: 120px;
        margin-top: -20px;
        height: 100%;
      };
    }

    .fourth {
      --app-box-background-front-layer: {
        background-image: url(//app-layout-assets.appspot.com/assets/bg4.jpg);
        background-position: bottom;
        padding-bottom: 120px;
        margin-top: -20px;
        height: 100%;
      };
    }

    section {
      padding-top: 100px;
    }

    article {
      font-weight: 100;
      max-width: 500px;
      text-align: center;
      margin: 0 auto 100px auto;
    }
    article h2 {
      font-weight: 100;
      font-size: 50px;
      margin: 5px;
    }
    article p {
      font-size: 18px;
      line-height: 30px;
    }

    article hr {
      width: 100px;
      height: 1px;
      border: none;
      margin: 20px auto;
      background-color: black;
    }
")

  (:body :!unresolved
(h/body :.fullbleed!unresolved
    (h/header
    (layout/toolbar
      (h/div :!main-title "POLYMER"))

    (layout/box {:threshold "64"}
      (h/ul :.nav {:role "navigation"}
        (h/li (h/a {:href "#speed"} "Speed"))
        (h/li (h/a {:href "#modern"} "Modern"))
        (h/li (h/a {:href "#standard"} "Standard"))
        (h/li (h/a {:href "#create"} "Create")))))

  (h/main
    (h/section :#speed
      (h/article
        (h/hr)
        (h/h2 "Built for Speed")
        (h/p "Polymer 1.0 replaces the shadow DOM polyfill with a lightweight shim, uses a new, faster data-binding system, and significantly reduces code size."))

      (layout/box :.first {:effects "parallax-background"}
          ;; app-box allows to style the mixin
          ;; `--app-box-background-front-layer` or create a custom
          ;; background in the light DOM.
          ;; In this case, we create a custom background by adding the
          ;; attribute `background` to the `img` in
          ;; the light DOM.

        (h/img :!background {:src "//app-layout-assets.appspot.com/assets/bg1.jpg"
                             :$width "100%"
                             :$height "900px"})))

    (h/section :#modern
      (h/article
        (h/hr)
        (h/h2 "For Modern Browsers")
        (h/p "Polymer is built from the ground up for modern browsers, using the latest web platform APIs. Polyfills provide support on evergreen browsers for APIs that aren't universal yet."))

        ;; This app-box uses the class `.second` and the mixin
        ;; `--app-box-background-front-layer` to assign the background
        ;; image.

      (layout/box :.second {:effects "parallax-background"}))


    (h/section :#standard
      (h/article
        (h/hr)
        (h/h2 "Using Web Components")
        (h/p "Polymer leverages web components, a new set of standards designed to provide reusable components for the web."))

      (layout/box :.third {:effects "parallax-background"}))

    (h/section :#create
      (h/article
        (h/hr)
        (h/h2 "Create your own elements")
        (h/p "The Polymer library makes it easy to create your own powerful elements. Give your element some markup and properties, and then use it on a site. Polymer provides useful features like templating and data binding to reduce the amount of boilerplate you need to write."))

      (layout/box :.fourth {:effects "parallax-background"}))))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(miraj/defpage ^{:miraj/demonstrates miraj.polymer.layout/box} index
  "Polymer App Box Demo."

  ;; html metadata first
  {:html/title "Polymer App Box Demo"
   :html/description "This page demonstrates a Polymer app-box element."}

  (:require [miraj.polymer.layout :as app :refer [box]])

  (:styles [[miraj.polymer.paper.styles color demo-pages typography]])

  (:css "
  a {
    display: block;
    margin-bottom: 10px;
  }
")

  ;; for boot-reload
  ;; (:js [{:src "main.js"}])

  (:body :!unresolved

   (h/h1 "Polymer " (h/span "<app-box>") " Demo")

   (h/div "The original demo is at "
          (h/a {:href "https://www.webcomponents.org/element/PolymerElements/app-box"}
               "webcomponents.org" ))

   (h/div :.horizontal-section-container
          (h/div
           (h/h4 "app-box demos")
           (h/div :.horizontal-section
                  (h/a {:href "document-scroll.html"} "Document Scroll")
                  (h/a {:href "scrolling-region.html"} "Scrolling Region"))))))

