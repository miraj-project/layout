(ns miraj.polymer.layout.demos.header
  (:require [miraj.core :as miraj]
            [miraj.html :as h]
            [miraj.polymer.layout :as layout]

            ;; for testing only:
            [miraj.compiler :as wc]
            [miraj.co-dom :as x]
            :reload))

(miraj/defpage ^{:miraj/demonstrates miraj.polymer.layout/header}
  blend-2
  "Polymer Header Demo - blend bg."

  {:html/title "app-header demo"
   :html/description "This page demonstrates a Polymer app-header element."}

  (:require [miraj.polymer.paper :as paper :refer [icon-button]]
            [miraj.polymer.layout :as app :refer [header toolbar]])

  ;;(:import  [[miraj.polymer.layout.demos.sample_content sample_data]])
  (:import  [[bower_components.app-layout.demo sample-content]])

  (:styles [[miraj.polymer.iron.icons iron]
            [miraj.polymer.layout.extensions scroll-effects]])

  (:css :custom "
    body {
      margin: 0;
      font-family: arial;
      background-color: #eee;
    }

    app-header {
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      height: 212px;
      color: #fff;
      background-color: #3f51b5;
      --app-header-background-front-layer: {
        background-image: url(//app-layout-assets.appspot.com/assets/bg1.jpg);
        background-position: left center;
      };
      --app-header-background-rear-layer: {
        background-image: url(//app-layout-assets.appspot.com/assets/bg2.jpg);
        background-position: left center;
      };
    }

    paper-icon-button {
      --paper-icon-button-ink-color: white;
    }

    app-toolbar.tall {
      height: 148px;
    }

    sample-content {
      padding-top: 212px;
    }

    [main-title] {
      font-weight: lighter;
      margin-left: 108px;
    }

    [condensed-title] {
      font-weight: lighter;
      margin-left: 30px;
      overflow: hidden;
      text-overflow: ellipsis;
    }

    [condensed-title] i {
      font-weight: 100;
      font-style: normal;
    }

    @media (max-width: 639px) {
      [main-title] {
        margin-left: 50px;
        font-size: 30px;
      }
      [condensed-title] {
        font-size: 15px;
      }
    }
")

  (:js [{:src "/js/main.js"}])


  (:body
   ;; (h/body :.fullbleed!unresolved
    (app/header :!condenses!reveals
                {:effects "waterfall resize-title blend-background parallax-background"}
    (app/toolbar
      (paper/icon-button {:icon "menu"})
      (h/h4 :!condensed-title "What is material? &mdash; Environment")
      (paper/icon-button {:icon "search"}))

    (app/toolbar :.tall
      (h/h1 :!main-title "What is material?")))

    (x/element :sample-content {:size "100"})))


