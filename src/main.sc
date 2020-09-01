
theme: /

    state: newNode_357
        if: $session.lastSeen
            go!: /newNode_358
        else:
            go!: /newNode_275

    state: newNode_275
        random:
            a:  Собирайте предметы,  деритесь с монстрами, умирайте и воскресайте. Следите за подсказками на экране.
                Чтобы узнать уровень здоровья и что у вас есть из предметов - скажите "Рюкзак".
                Начнём? || tts = "<speaker audio="alice-music-bagpipes-1.opus"> Добро пожаловать в "Цитадель"!\nСледите за подсказками на экране.\nЧтобы узнать  уровень здоровья и что у вас есть из предметов - скажите "Рюкзак". Готовы?", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/S7rUQNQkR64VAcqa.jpg
        go!: /newNode_308
    @IntentGroup
        {
          "boundsTo" : "/newNode_275",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Помощь",
                  "transition" : ""
                },
                {
                  "name" : "Что ты еще умеешь? ",
                  "transition" : ""
                },
                {
                  "name" : "Старт!",
                  "transition" : "/newNode_65"
                }
              ]
            }
          ],
          "global" : true,
          "fallback" : "/newNode_65",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "старт"
                },
                {
                  "type" : "pattern",
                  "value" : "начать"
                },
                {
                  "type" : "pattern",
                  "value" : "начать с начала"
                }
              ],
              "then" : "/newNode_65"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "Помощь"
                },
                {
                  "type" : "example",
                  "value" : "помощь"
                }
              ],
              "then" : "/newNode_208"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "Что ты еще умеешь"
                },
                {
                  "type" : "pattern",
                  "value" : "что ты еще умеешь"
                }
              ],
              "then" : "/newNode_350"
            }
          ]
        }
    state: newNode_308
        state: 1
            e!: старт
            q!: начать
            q!: начать с начала

            go!: /newNode_65

        state: 2
            e!: помощь
            q!: Помощь

            go!: /newNode_208

        state: 3
            q!: Что ты еще умеешь
            q!: что ты еще умеешь

            go!: /newNode_350

        state: Fallback
            q: *
            go!: /newNode_65
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_308",
                name: "newNode_308 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Помощь"
                    },
                    {text: "Что ты еще умеешь? "
                    },
                    {text: "Старт!"
                    , transition: "/newNode_65"
                    },
                  ]);
                }
            });

    state: newNode_65
        if: $session.zd = 100
            go!: /newNode_7

    state: newNode_7
        if: $session.loot = "пусто";
            go!: /newNode_224
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "global" : true,
          "fallback" : "",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "хватит"
                },
                {
                  "type" : "pattern",
                  "value" : "завершить"
                }
              ],
              "then" : "/newNode_356"
            }
          ]
        }
    state: newNode_355
        state: 1
            q!: хватит
            q!: завершить

            go!: /newNode_356
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_355",
                name: "newNode_355 buttons",
                handler: function($context) {
                }
            });
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "global" : false,
          "fallback" : "",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "Помощь"
                },
                {
                  "type" : "pattern",
                  "value" : "помощь"
                }
              ],
              "then" : "/newNode_208"
            }
          ]
        }
    state: newNode_352
        state: 1
            q: Помощь
            q: помощь

            go!: /newNode_208
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_352",
                name: "newNode_352 buttons",
                handler: function($context) {
                }
            });

    state: newNode_208
        random:
            a: Собирайте предметы и следите за подсказками-кнопками.  Уровень здоровья и наличие предметов можно узнать командой "рюкзак".
        go!: /newNode_351
    @IntentGroup
        {
          "boundsTo" : "/newNode_208",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Играть",
                  "transition" : "/newNode_65"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_65",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "Играть"
                },
                {
                  "type" : "example",
                  "value" : "играть"
                }
              ],
              "then" : "/newNode_65"
            }
          ]
        }
    state: newNode_351
        state: 1
            e: играть
            q: Играть

            go!: /newNode_65

        state: Fallback
            q: *
            go!: /newNode_65
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_351",
                name: "newNode_351 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Играть"
                    , transition: "/newNode_65"
                    },
                  ]);
                }
            });
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [ ],
          "global" : true,
          "fallback" : "",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "что ты еще умеешь?"
                },
                {
                  "type" : "pattern",
                  "value" : "что ты умеешь"
                },
                {
                  "type" : "example",
                  "value" : "что еще ты умеешь"
                }
              ],
              "then" : "/newNode_350"
            }
          ]
        }
    state: newNode_309
        state: 1
            e!: что еще ты умеешь
            q!: что ты еще умеешь?
            q!: что ты умеешь

            go!: /newNode_350

    state: newNode_350
        random:
            a: Я знаю команды: "помощь", "воскреснуть", "рюкзак".  Зомби не будут ждать!
        go!: /newNode_353
    @IntentGroup
        {
          "boundsTo" : "/newNode_350",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Играть",
                  "transition" : "/newNode_65"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_65",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "Играть"
                },
                {
                  "type" : "example",
                  "value" : "играть"
                }
              ],
              "then" : ""
            }
          ]
        }
    state: newNode_353
        state: 1
            e: играть
            q: Играть

            go!: /

        state: Fallback
            q: *
            go!: /newNode_65
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_353",
                name: "newNode_353 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Играть"
                    , transition: "/newNode_65"
                    },
                  ]);
                }
            });
    @EndSession
        {
          "boundsTo" : ""
        }
    state: newNode_356
        script:
            $session = new Object();
            $response.endSession = true;

    state: newNode_358
        random:
            a:  С возвращением! Собирайте предметы,  деритесь с монстрами, умирайте и воскресайте. Следите за подсказками на экране.
                Чтобы узнать уровень здоровья и что у вас есть из предметов - скажите "Рюкзак".
                Начнём?
        go!: /newNode_359
    @IntentGroup
        {
          "boundsTo" : "/newNode_358",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Старт",
                  "transition" : "/newNode_65"
                }
              ]
            }
          ],
          "global" : true,
          "fallback" : "/newNode_65",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "старт"
                },
                {
                  "type" : "pattern",
                  "value" : "начать"
                },
                {
                  "type" : "pattern",
                  "value" : "начать с начала"
                }
              ],
              "then" : "/newNode_65"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "Помощь"
                },
                {
                  "type" : "example",
                  "value" : "помощь"
                }
              ],
              "then" : ""
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "Что ты еще умеешь"
                },
                {
                  "type" : "pattern",
                  "value" : "что ты еще умеешь"
                }
              ],
              "then" : ""
            }
          ]
        }
    state: newNode_359
        state: 1
            e!: старт
            q!: начать
            q!: начать с начала

            go!: /newNode_65

        state: 2
            e!: помощь
            q!: Помощь

            go!: /

        state: 3
            q!: Что ты еще умеешь
            q!: что ты еще умеешь

            go!: /

        state: Fallback
            q: *
            go!: /newNode_65
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_359",
                name: "newNode_359 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Старт"
                    , transition: "/newNode_65"
                    },
                  ]);
                }
            });

    state: newNode_224
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/D1zY3kRYVPm25NUq.jpg
        random:
            a: Вы проснулись в лесу посреди поляны цветов и ягод, и не помните как здесь оказались. Неподалёку шевелится странный, огромных размеров мухомор... || tts = "<speaker audio="alice-sounds-nature-forest-1.opus"> Вы проснулись в лесу посреди поляны цветов и ягод, и не помните как здесь оказалась. Неподалёку шевелится странный, огромных размеров мухомор...", ttsEnabled = true
        go!: /newNode_225
    @Transition
        {
          "boundsTo" : "/newNode_224",
          "then" : "/newNode_15"
        }
    state: newNode_225
        go!: /newNode_15
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "собирать ягоды",
                  "transition" : "/newNode_11"
                },
                {
                  "name" : "идти к мухомору",
                  "transition" : "/newNode_12"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_9"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_11",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "подойти к мухомору"
                },
                {
                  "type" : "pattern",
                  "value" : "идти к мухомору"
                },
                {
                  "type" : "example",
                  "value" : "подойти к грибу"
                },
                {
                  "type" : "example",
                  "value" : "мухомор"
                }
              ],
              "then" : "/newNode_12"
            }
          ]
        }
    state: newNode_15
        state: 1
            e: подойти к грибу
            e: мухомор
            q: подойти к мухомору
            q: идти к мухомору

            go!: /newNode_12

        state: Fallback
            q: *
            go!: /newNode_11
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_15",
                name: "newNode_15 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "собирать ягоды"
                    , transition: "/newNode_11"
                    },
                    {text: "идти к мухомору"
                    , transition: "/newNode_12"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_9"
                    },
                  ]);
                }
            });

    state: newNode_9
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_16
    @Transition
        {
          "boundsTo" : "/newNode_9",
          "then" : "/newNode_15"
        }
    state: newNode_16
        go!: /newNode_15

    state: newNode_11
        if: $session.zd -= 20;
            go!: /newNode_226
        else:
            go!: /newNode_226

    state: newNode_226
        random:
            a: Вы находите в траве красивые ягоды и пробуете их на вкус.  Кисленькие...  Кажется,  они ядовитые. У вас темнеет в глазах.  Вы потеряли 20% здоровья. || tts = "<speaker audio="alice-sounds-human-laugh-3.opus"> Ягоды оказались кисленькие...  Но ядовитые. Вы потеряли 20% здоровья.", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/P726Wm9yreN9iORX.jpg
        go!: /newNode_227
    @Transition
        {
          "boundsTo" : "/newNode_226",
          "then" : "/newNode_33"
        }
    state: newNode_227
        go!: /newNode_33
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_20"
                },
                {
                  "name" : "идти к мухомору",
                  "transition" : "/newNode_12"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_12",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "идти к мухомору"
                },
                {
                  "type" : "example",
                  "value" : "мухомор"
                }
              ],
              "then" : "/newNode_12"
            }
          ]
        }
    state: newNode_33
        state: 1
            e: идти к мухомору
            e: мухомор

            go!: /newNode_12

        state: Fallback
            q: *
            go!: /newNode_12
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_33",
                name: "newNode_33 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Рюкзак"
                    , transition: "/newNode_20"
                    },
                    {text: "идти к мухомору"
                    , transition: "/newNode_12"
                    },
                  ]);
                }
            });

    state: newNode_20
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_21
    @Transition
        {
          "boundsTo" : "/newNode_20",
          "then" : "/newNode_33"
        }
    state: newNode_21
        go!: /newNode_33

    state: newNode_12
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/TzewwEjSuqT7r7eH.jpg
        random:
            a: "Здравствуй, помятый человек.  Шучу! Не обижайся. Ты попал в заколдованный лес.  Меня зовут Дух леса."
        go!: /newNode_244
    @Transition
        {
          "boundsTo" : "/newNode_12",
          "then" : "/newNode_243"
        }
    state: newNode_244
        go!: /newNode_243
    @InputText
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "prompt" : "А тебя как зовут?",
          "varName" : "name",
          "then" : "/newNode_228"
        }
    state: newNode_243 || modal = true
        a: А тебя как зовут?

        state:
            q: * *start *
            script:
              Zenflow.start();

        state: CatchText
            q: *
            script:
                addClientVarToSession("name", $parseTree.text);
            go!: /newNode_228
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_243",
                name: "newNode_243 buttons",
                handler: function($context) {
                }
            });

    state: newNode_228
        random:
            a: "Очень приятно, {{$session.name}}! Не боишься ты?  Чую, скоро начнется гроза, - я бы на твоём месте поискал где укрыться" || tts = "Очень приятно, {{$session.name}}! Не боишься ты?  Чую, скоро начнется гроза, - я бы на твоём месте поискал где укрыться" <speaker audio="alice-sounds-nature-thunder-1.opus">", ttsEnabled = true
        go!: /newNode_229
    @Transition
        {
          "boundsTo" : "/newNode_228",
          "then" : "/newNode_310"
        }
    state: newNode_229
        go!: /newNode_310
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Почему?",
                  "transition" : "/newNode_300"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_18"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_300",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "почему"
                }
              ],
              "then" : "/newNode_300"
            }
          ]
        }
    state: newNode_310
        state: 1
            q: почему

            go!: /newNode_300

        state: Fallback
            q: *
            go!: /newNode_300
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_310",
                name: "newNode_310 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Почему?"
                    , transition: "/newNode_300"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_18"
                    },
                  ]);
                }
            });

    state: newNode_18
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_19
    @Transition
        {
          "boundsTo" : "/newNode_18",
          "then" : "/newNode_310"
        }
    state: newNode_19
        go!: /newNode_310
    @IntentGroup
        {
          "boundsTo" : "",
          "title" : "ОЖИВЛЕНИЕ",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "global" : true,
          "fallback" : "",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "Воскреснуть"
                },
                {
                  "type" : "pattern",
                  "value" : "воскреснуть"
                },
                {
                  "type" : "example",
                  "value" : "ожить"
                }
              ],
              "then" : "/newNode_325"
            }
          ]
        }
    state: newNode_207
        state: 1
            e!: ожить
            q!: Воскреснуть
            q!: воскреснуть

            go!: /newNode_325
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_207",
                name: "newNode_207 buttons",
                handler: function($context) {
                }
            });

    state: newNode_325
        if: $session.zd = 100
            go!: /newNode_326

    state: newNode_326
        if: $session.loot = "пусто";
            go!: /newNode_254

    state: newNode_300
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/DVP8SQ5TMaqCkQr5.jpg
        random:
            a:  "Когда-то это был чудесный лес, но последнее время творятся непонятные вещи: животные погибают, растения наполняются ядом,  идущим из цитадели.
                Если ты поможешь разобраться с этой чертовщиной, я помогу тебе вернуться домой.  Ты согласен?"
        go!: /newNode_301
    @Transition
        {
          "boundsTo" : "/newNode_300",
          "then" : "/newNode_24"
        }
    state: newNode_301
        go!: /newNode_24
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Пожалуй, да",
                  "transition" : "/newNode_256"
                },
                {
                  "name" : "Наверное нет",
                  "transition" : "/newNode_258"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_25"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_258",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "Да"
                }
              ],
              "then" : "/newNode_256"
            },
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "Нет"
                }
              ],
              "then" : "/newNode_258"
            }
          ]
        }
    state: newNode_24
        state: 1
            e: Да

            go!: /newNode_256

        state: 2
            e: Нет

            go!: /newNode_258

        state: Fallback
            q: *
            go!: /newNode_258
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_24",
                name: "newNode_24 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Пожалуй, да"
                    , transition: "/newNode_256"
                    },
                    {text: "Наверное нет"
                    , transition: "/newNode_258"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_25"
                    },
                  ]);
                }
            });

    state: newNode_25
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_26
    @Transition
        {
          "boundsTo" : "/newNode_25",
          "then" : "/newNode_24"
        }
    state: newNode_26
        go!: /newNode_24

    state: newNode_258
        random:
            a: Гриб куда-то пропал. Стало смеркаться, дождь усилился. Что делать?
        go!: /newNode_259
    @Transition
        {
          "boundsTo" : "/newNode_258",
          "then" : "/newNode_328"
        }
    state: newNode_259
        go!: /newNode_328
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Спрятаться под деревом",
                  "transition" : "/newNode_28"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_61"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_28",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "спрятаться под деревом"
                },
                {
                  "type" : "pattern",
                  "value" : "прятаться"
                },
                {
                  "type" : "example",
                  "value" : "спрятаться"
                }
              ],
              "then" : "/newNode_28"
            }
          ]
        }
    state: newNode_328
        state: 1
            e: спрятаться
            q: спрятаться под деревом
            q: прятаться

            go!: /newNode_28

        state: Fallback
            q: *
            go!: /newNode_28
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_328",
                name: "newNode_328 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Спрятаться под деревом"
                    , transition: "/newNode_28"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_61"
                    },
                  ]);
                }
            });

    state: newNode_61
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_62
    @Transition
        {
          "boundsTo" : "/newNode_61",
          "then" : "/newNode_328"
        }
    state: newNode_62
        go!: /newNode_328

    state: newNode_28
        random:
            a: Молния ударила в дерево под которым вы прятались. Вас испепелило! || tts = "<speaker audio="alice-sounds-game-loss-3.opus"> Молния ударила в дерево под которым вы прятались. Вас испепелило! <speaker audio="alice-sounds-nature-thunder-2.opus">", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/3z3zltHPTwKEX3rN.jpg
        buttons:
            "Воскреснуть" -> /newNode_224
            {text: "Поставить оценку", url: "https://dialogs.yandex.ru/store/skills/deeb023c-citadel-chast-perva"}

    state: newNode_256
        random:
            a: "Там, за пригорком,  за старым дубом есть нора. В ней ты можешь найти укрытие от грозы. Поторопись!"
        go!: /newNode_257
    @Transition
        {
          "boundsTo" : "/newNode_256",
          "then" : "/newNode_30"
        }
    state: newNode_257
        go!: /newNode_30
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Стоять тут",
                  "transition" : "/newNode_258"
                },
                {
                  "name" : "Идти к дубу",
                  "transition" : "/newNode_254"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_31"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_258",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "Остаться"
                },
                {
                  "type" : "example",
                  "value" : "стоять"
                }
              ],
              "then" : "/newNode_28"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "Идти к дубу"
                },
                {
                  "type" : "pattern",
                  "value" : "идти к дубу"
                },
                {
                  "type" : "example",
                  "value" : "идти"
                }
              ],
              "then" : "/newNode_254"
            }
          ]
        }
    state: newNode_30
        state: 1
            e: Остаться
            e: стоять

            go!: /newNode_28

        state: 2
            e: идти
            q: Идти к дубу
            q: идти к дубу

            go!: /newNode_254

        state: Fallback
            q: *
            go!: /newNode_258
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_30",
                name: "newNode_30 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Стоять тут"
                    , transition: "/newNode_258"
                    },
                    {text: "Идти к дубу"
                    , transition: "/newNode_254"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_31"
                    },
                  ]);
                }
            });

    state: newNode_31
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_32
    @Transition
        {
          "boundsTo" : "/newNode_31",
          "then" : "/newNode_30"
        }
    state: newNode_32
        go!: /newNode_30

    state: newNode_254
        random:
            a: Перед вами раскинулся старый, мощный дуб. В корнях дуба, за ветками виднеется вход в чью-то нору. Что будете делать? || tts = "<speaker audio="alice-sounds-animals-owl-1.opus"> Перед вами раскинулся старый, мощный дуб. В корнях дуба, за ветками виднеется вход в чью-то нору.", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/vMpRxsSKhh53yOFo.jpg
        go!: /newNode_255
    @Transition
        {
          "boundsTo" : "/newNode_254",
          "then" : "/newNode_35"
        }
    state: newNode_255
        go!: /newNode_35
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Осмотреть дуб",
                  "transition" : "/newNode_230"
                },
                {
                  "name" : "Прыгнуть в нору",
                  "transition" : "/newNode_232"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_36"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_230",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "смотреть дуб"
                },
                {
                  "type" : "example",
                  "value" : "осмотеть дуб"
                }
              ],
              "then" : "/newNode_230"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "прыгнуть"
                },
                {
                  "type" : "example",
                  "value" : "Прыгнуть в нору"
                },
                {
                  "type" : "example",
                  "value" : "прыгну"
                },
                {
                  "type" : "example",
                  "value" : "прыгну в нору"
                }
              ],
              "then" : "/newNode_232"
            }
          ]
        }
    state: newNode_35
        state: 1
            e: смотреть дуб
            e: осмотеть дуб

            go!: /newNode_230

        state: 2
            e: Прыгнуть в нору
            e: прыгну
            e: прыгну в нору
            q: прыгнуть

            go!: /newNode_232

        state: Fallback
            q: *
            go!: /newNode_230
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_35",
                name: "newNode_35 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Осмотреть дуб"
                    , transition: "/newNode_230"
                    },
                    {text: "Прыгнуть в нору"
                    , transition: "/newNode_232"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_36"
                    },
                  ]);
                }
            });

    state: newNode_36
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_37
    @Transition
        {
          "boundsTo" : "/newNode_36",
          "then" : "/newNode_35"
        }
    state: newNode_37
        go!: /newNode_35

    state: newNode_230
        random:
            a: Под листвой дуба вы видите дупло. Кажется, там никто не живёт. Может посмотреть что в дупле?
        go!: /newNode_246
    @Transition
        {
          "boundsTo" : "/newNode_230",
          "then" : "/newNode_39"
        }
    state: newNode_246
        go!: /newNode_39
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Нет",
                  "transition" : "/newNode_232"
                },
                {
                  "name" : "Да, посмотреть",
                  "transition" : "/newNode_43"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_40"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_232",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "Да, посмотреть"
                },
                {
                  "type" : "example",
                  "value" : "Да"
                }
              ],
              "then" : "/newNode_43"
            },
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "Нет"
                }
              ],
              "then" : "/newNode_232"
            }
          ]
        }
    state: newNode_39
        state: 1
            e: Да, посмотреть
            e: Да

            go!: /newNode_43

        state: 2
            e: Нет

            go!: /newNode_232

        state: Fallback
            q: *
            go!: /newNode_232
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_39",
                name: "newNode_39 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Нет"
                    , transition: "/newNode_232"
                    },
                    {text: "Да, посмотреть"
                    , transition: "/newNode_43"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_40"
                    },
                  ]);
                }
            });

    state: newNode_40
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_41
    @Transition
        {
          "boundsTo" : "/newNode_40",
          "then" : "/newNode_39"
        }
    state: newNode_41
        go!: /newNode_39

    state: newNode_43
        if: $session.loot = "кость";
            go!: /newNode_248
        else:
            go!: /newNode_248

    state: newNode_248
        random:
            a: На дне дупла вы нашли чью-то обглоданную кость. Странные здесь белки, да? На всякий случай убрали кость в рюкзак -вдруг пригодится. || tts = "<speaker audio="alice-music-guitar-a-1.opus"> На дне дупла вы нашли чью-то обглоданную кость. Странные здесь белки, да?!", ttsEnabled = true
        go!: /newNode_249
    @Transition
        {
          "boundsTo" : "/newNode_248",
          "then" : "/newNode_134"
        }
    state: newNode_249
        go!: /newNode_134
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Прыгнуть в нору",
                  "transition" : "/newNode_232"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_45"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_232",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "Прыгнуть в нору"
                },
                {
                  "type" : "example",
                  "value" : "прыгнуть в нору"
                },
                {
                  "type" : "example",
                  "value" : "прыгнуть"
                }
              ],
              "then" : "/newNode_232"
            }
          ]
        }
    state: newNode_134
        state: 1
            e: Прыгнуть в нору
            e: прыгнуть в нору
            e: прыгнуть

            go!: /newNode_232

        state: Fallback
            q: *
            go!: /newNode_232
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_134",
                name: "newNode_134 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Прыгнуть в нору"
                    , transition: "/newNode_232"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_45"
                    },
                  ]);
                }
            });

    state: newNode_45
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_46
    @Transition
        {
          "boundsTo" : "/newNode_45",
          "then" : "/newNode_134"
        }
    state: newNode_46
        go!: /newNode_134

    state: newNode_232
        random:
            a: Вы оказались в норе. Дождь разошелся ни на шутку.  Нора уходит глубоко вниз и, кажется,  тут есть целый подземный ход! Одолевает усталость и хочется спать. || tts = "Вы оказались в норе. Дождь разошелся ни на шутку.  Нора уходит глубоко вниз и, кажется,  тут есть целый подземный ход! Одолевает усталость и хочется спать.", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/WO7yAVm2Kg26NJ8H.jpg
        go!: /newNode_233
    @Transition
        {
          "boundsTo" : "/newNode_232",
          "then" : "/newNode_50"
        }
    state: newNode_233
        go!: /newNode_50
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Лечь спать",
                  "transition" : "/newNode_234"
                },
                {
                  "name" : "Идти в тоннель",
                  "transition" : "/newNode_231"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_48"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_234",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "Спать"
                },
                {
                  "type" : "example",
                  "value" : "Лечь спать"
                }
              ],
              "then" : "/newNode_234"
            },
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "Идти в тоннель"
                },
                {
                  "type" : "example",
                  "value" : "Идти вперед"
                },
                {
                  "type" : "example",
                  "value" : "Идти"
                }
              ],
              "then" : "/newNode_231"
            }
          ]
        }
    state: newNode_50
        state: 1
            e: Спать
            e: Лечь спать

            go!: /newNode_234

        state: 2
            e: Идти в тоннель
            e: Идти вперед
            e: Идти

            go!: /newNode_231

        state: Fallback
            q: *
            go!: /newNode_234
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_50",
                name: "newNode_50 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Лечь спать"
                    , transition: "/newNode_234"
                    },
                    {text: "Идти в тоннель"
                    , transition: "/newNode_231"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_48"
                    },
                  ]);
                }
            });

    state: newNode_48
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_49
    @Transition
        {
          "boundsTo" : "/newNode_48",
          "then" : "/newNode_50"
        }
    state: newNode_49
        go!: /newNode_50

    state: newNode_234
        if: $session.zd -=30;
            go!: /newNode_51
        else:
            go!: /newNode_51

    state: newNode_51
        random:
            a: Вы прилегли на бочок и вас покусал серый волчок.  Оказалось, что это волчья нора. Вы потеряли 30% здоровья и насилу унесли ноги! || tts = "<speaker audio="alice-sounds-animals-wolf-1.opus"> Вы прилегли на бочок и вас почти сожрали волки. Потеряв 30% здоровья,  вы насилу унесли н+оги!<speaker audio="alice-sounds-human-laugh-3.opus">", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/EsMeC21IlLIS5oXy.jpg
        go!: /newNode_303
    @Transition
        {
          "boundsTo" : "/newNode_51",
          "then" : "/newNode_331"
        }
    state: newNode_303
        go!: /newNode_331
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "идти",
                  "transition" : "/newNode_231"
                },
                {
                  "name" : "рюкзак",
                  "transition" : "/newNode_329"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_231",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "идти"
                }
              ],
              "then" : "/newNode_231"
            }
          ]
        }
    state: newNode_331
        state: 1
            q: идти

            go!: /newNode_231

        state: Fallback
            q: *
            go!: /newNode_231
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_331",
                name: "newNode_331 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "идти"
                    , transition: "/newNode_231"
                    },
                    {text: "рюкзак"
                    , transition: "/newNode_329"
                    },
                  ]);
                }
            });

    state: newNode_329
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_330
    @Transition
        {
          "boundsTo" : "/newNode_329",
          "then" : "/newNode_331"
        }
    state: newNode_330
        go!: /newNode_331

    state: newNode_231
        random:
            a: Вы долго шли в кромешной тьме и наконец вдалеке показался свет. Осторожно, ползком  вы подбирались к огням,  и оказались во дворе замка. От запаха смрада вам нехорошо. || tts = "<speaker audio="alice-music-horn-2.opus"> наконец вдалеке показался свет. Ползком  вы подбирались к огням,  и оказались во дворе замка.", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/DX4l9Ys0RBXOU798.jpg
        go!: /newNode_247
    @Transition
        {
          "boundsTo" : "/newNode_231",
          "then" : "/newNode_216"
        }
    state: newNode_247
        go!: /newNode_216
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "войти в цитадель",
                  "transition" : "/newNode_58"
                },
                {
                  "name" : "осмотреть двор",
                  "transition" : "/newNode_250"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_56"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_250",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "войти в цитадель"
                },
                {
                  "type" : "example",
                  "value" : "зайти в цитадель"
                },
                {
                  "type" : "example",
                  "value" : "цитадель"
                }
              ],
              "then" : "/newNode_58"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "смотреть двор"
                },
                {
                  "type" : "pattern",
                  "value" : "осмотреть двор"
                }
              ],
              "then" : "/newNode_250"
            }
          ]
        }
    state: newNode_216
        state: 1
            e: войти в цитадель
            e: зайти в цитадель
            e: цитадель

            go!: /newNode_58

        state: 2
            q: смотреть двор
            q: осмотреть двор

            go!: /newNode_250

        state: Fallback
            q: *
            go!: /newNode_250
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_216",
                name: "newNode_216 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "войти в цитадель"
                    , transition: "/newNode_58"
                    },
                    {text: "осмотреть двор"
                    , transition: "/newNode_250"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_56"
                    },
                  ]);
                }
            });

    state: newNode_56
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_57
    @Transition
        {
          "boundsTo" : "/newNode_56",
          "then" : "/newNode_216"
        }
    state: newNode_57
        go!: /newNode_216

    state: newNode_250
        random:
            a: Неплохо бы подкрепиться? Неподалёку стоит заброшенная хижина, и какой-то дом, похожий на склад. Куда отправимся сначала? || tts = "Неплохо бы подкрепиться? Неподалёку сто+ит заброшенная хижина, и какой-то дом, похожий на склад. Куда отправимся сначала?", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/LWNFAZjs62L8YIhP.jpg
        go!: /newNode_251
    @Transition
        {
          "boundsTo" : "/newNode_250",
          "then" : "/newNode_87"
        }
    state: newNode_251
        go!: /newNode_87
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_82"
                },
                {
                  "name" : "склад",
                  "transition" : "/newNode_98"
                },
                {
                  "name" : "хижина",
                  "transition" : "/newNode_90"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_98",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "склад"
                },
                {
                  "type" : "example",
                  "value" : "на склад"
                }
              ],
              "then" : "/newNode_98"
            },
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "хижина"
                },
                {
                  "type" : "example",
                  "value" : "в хижину"
                }
              ],
              "then" : "/newNode_90"
            }
          ]
        }
    state: newNode_87
        state: 1
            e: склад
            e: на склад

            go!: /newNode_98

        state: 2
            e: хижина
            e: в хижину

            go!: /newNode_90

        state: Fallback
            q: *
            go!: /newNode_98
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_87",
                name: "newNode_87 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Рюкзак"
                    , transition: "/newNode_82"
                    },
                    {text: "склад"
                    , transition: "/newNode_98"
                    },
                    {text: "хижина"
                    , transition: "/newNode_90"
                    },
                  ]);
                }
            });

    state: newNode_82
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_83
    @Transition
        {
          "boundsTo" : "/newNode_82",
          "then" : "/newNode_87"
        }
    state: newNode_83
        go!: /newNode_87

    state: newNode_90
        if: $session.loot == "кость";
            go!: /newNode_91
        else:
            go!: /newNode_92

    state: newNode_91
        if: $session.loot = "кость, меч";
            go!: /newNode_252
        else:
            go!: /newNode_92

    state: newNode_92
        if: $session.loot = "меч";
            go!: /newNode_252

    state: newNode_98
        if: $session.loot == "пусто";
            go!: /newNode_99
        else:
            go!: /newNode_100

    state: newNode_99
        if: $session.loot = "сало";
            go!: /newNode_260

    state: newNode_100
        if: $session.loot = "кость, сало"
            go!: /newNode_260

    state: newNode_252
        random:
            a: Под пыльными сводами хижины вы обнаружили что-то поблескивающее... Ножны! Да это же меч! || tts = "Под пыльными сводами хижины вы обнаружили что-то поблескивающее... <speaker audio="alice-sounds-things-sword-2.opus">  Н+ожны! Да это же меч!", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/Q1qj9ncXQP41wLpr.jpg
        go!: /newNode_253
    @Transition
        {
          "boundsTo" : "/newNode_252",
          "then" : "/newNode_302"
        }
    state: newNode_253
        go!: /newNode_302
    @InputText
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Склад",
                  "transition" : "/newNode_93"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_135"
                }
              ]
            }
          ],
          "prompt" : "Вот бы перекусить чего-нибудь.",
          "varName" : "text",
          "then" : "/newNode_93"
        }
    state: newNode_302 || modal = true
        a: Вот бы перекусить чего-нибудь.

        state:
            q: * *start *
            script:
              Zenflow.start();

        state: CatchText
            q: *
            script:
                addClientVarToSession("text", $parseTree.text);
            go!: /newNode_93
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_302",
                name: "newNode_302 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Склад"
                    , transition: "/newNode_93"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_135"
                    },
                  ]);
                }
            });

    state: newNode_135
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_136
    @Transition
        {
          "boundsTo" : "/newNode_135",
          "then" : "/newNode_302"
        }
    state: newNode_136
        go!: /newNode_302

    state: newNode_260
        random:
            a: Да это же и правда бывший склад! Вы находите смачный шматок сала и буханку хлеба! || tts = "<speaker audio="alice-music-guitar-c-1.opus">Да это же и правда бывший склад! Вы находите смачный шмат+ок сала и буханку хлеба!", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/Tjy265Yx49WOENDB.jpg
        go!: /newNode_312
    @Transition
        {
          "boundsTo" : "/newNode_260",
          "then" : "/newNode_311"
        }
    state: newNode_312
        go!: /newNode_311
    @InputText
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Да",
                  "transition" : "/newNode_104"
                },
                {
                  "name" : "Нет",
                  "transition" : "/newNode_304"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_137"
                }
              ]
            }
          ],
          "prompt" : "Желаете откушать сейчас?",
          "varName" : "text345",
          "then" : "/newNode_304"
        }
    state: newNode_311 || modal = true
        a: Желаете откушать сейчас?

        state:
            q: * *start *
            script:
              Zenflow.start();

        state: CatchText
            q: *
            script:
                addClientVarToSession("text345", $parseTree.text);
            go!: /newNode_304
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_311",
                name: "newNode_311 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Да"
                    , transition: "/newNode_104"
                    },
                    {text: "Нет"
                    , transition: "/newNode_304"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_137"
                    },
                  ]);
                }
            });

    state: newNode_137
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_261
    @Transition
        {
          "boundsTo" : "/newNode_137",
          "then" : "/newNode_311"
        }
    state: newNode_261
        go!: /newNode_311

    state: newNode_104
        if: $session.loot == "кость, сало";
            go!: /newNode_107
        elseif: $session.loot == "сало";
            go!: /newNode_105

    state: newNode_107
        if: $session.loot = "кость";
            go!: /newNode_106

    state: newNode_105
        if: $session.loot = "пусто";
            go!: /newNode_106

    state: newNode_106
        random:
            a: Вкуснятина! К вашему здоровью прибавилось 40% || tts = "<speaker audio="alice-music-harp-1.opus"> Вкуснятина! К вашему здоровью прибавилось 40%", ttsEnabled = true
        if: $session.zd += 40;
            go!: /newNode_304
        else:
            go!: /newNode_304

    state: newNode_111
        if: $session.loot == "пусто";
            go!: /newNode_113
        elseif: $session.loot == "сало";
            go!: /newNode_114
        elseif: $session.loot == "кость";
            go!: /newNode_115
        elseif: $session.loot == "кость, сало";
            go!: /newNode_116

    state: newNode_113
        if: $session.loot = "меч";
            go!: /newNode_264

    state: newNode_114
        if: $session.loot = "меч, сало";
            go!: /newNode_264

    state: newNode_115
        if: $session.loot = "кость, меч";
            go!: /newNode_264

    state: newNode_116
        if: $session.loot = "кость, меч, сало";
            go!: /newNode_264

    state: newNode_304
        random:
            a: Куда дальше?
        go!: /newNode_332
    @IntentGroup
        {
          "boundsTo" : "/newNode_304",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "хижина",
                  "transition" : "/newNode_111"
                },
                {
                  "name" : "сарай",
                  "transition" : "/newNode_270"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_139"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_270",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "хижина"
                },
                {
                  "type" : "example",
                  "value" : "в хижину"
                }
              ],
              "then" : "/newNode_111"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "сарай"
                },
                {
                  "type" : "example",
                  "value" : "в сарай"
                }
              ],
              "then" : "/newNode_270"
            }
          ]
        }
    state: newNode_332
        state: 1
            e: в хижину
            q: хижина

            go!: /newNode_111

        state: 2
            e: в сарай
            q: сарай

            go!: /newNode_270

        state: Fallback
            q: *
            go!: /newNode_270
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_332",
                name: "newNode_332 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "хижина"
                    , transition: "/newNode_111"
                    },
                    {text: "сарай"
                    , transition: "/newNode_270"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_139"
                    },
                  ]);
                }
            });

    state: newNode_139
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_140
    @Transition
        {
          "boundsTo" : "/newNode_139",
          "then" : "/newNode_304"
        }
    state: newNode_140
        go!: /newNode_304

    state: newNode_93
        if: $session.loot == "меч";
            go!: /newNode_94
        elseif: $session.loot == "кость, меч";
            go!: /newNode_95

    state: newNode_94
        if: $session.loot = "меч, сало";
            go!: /newNode_266

    state: newNode_95
        if: $session.loot = "кость, меч, сало";
            go!: /newNode_266

    state: newNode_264
        random:
            a:  Под пыльными сводами хижины вы обнаружили что-то поблескивающее... Ножны! Да это же меч!
                Куда пойдем дальше? || tts = "Вы обнаружили что-то поблескивающее... <speaker audio="alice-sounds-things-sword-2.opus"> Н+ожны! Да это же меч! Куда дальше?", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/vJl4b3hr9MQZaUEo.jpg
        go!: /newNode_265
    @Transition
        {
          "boundsTo" : "/newNode_264",
          "then" : "/newNode_333"
        }
    state: newNode_265
        go!: /newNode_333
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "сарай",
                  "transition" : "/newNode_96"
                },
                {
                  "name" : "цитадель",
                  "transition" : "/newNode_58"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_141"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_96",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "сарай"
                },
                {
                  "type" : "example",
                  "value" : "Сарай"
                }
              ],
              "then" : "/newNode_96"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "цитадель"
                },
                {
                  "type" : "example",
                  "value" : "в цитадель"
                },
                {
                  "type" : "example",
                  "value" : "Цитадель"
                }
              ],
              "then" : "/newNode_58"
            }
          ]
        }
    state: newNode_333
        state: 1
            e: Сарай
            q: сарай

            go!: /newNode_96

        state: 2
            e: в цитадель
            e: Цитадель
            q: цитадель

            go!: /newNode_58

        state: Fallback
            q: *
            go!: /newNode_96
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_333",
                name: "newNode_333 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "сарай"
                    , transition: "/newNode_96"
                    },
                    {text: "цитадель"
                    , transition: "/newNode_58"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_141"
                    },
                  ]);
                }
            });

    state: newNode_141
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_142
    @Transition
        {
          "boundsTo" : "/newNode_141",
          "then" : "/newNode_333"
        }
    state: newNode_142
        go!: /newNode_333

    state: newNode_266
        random:
            a:  Да это же и правда бывший склад! Вы находите смачный шматок сала и буханку хлеба!
                Желаете откушать сейчас? || tts = "<speaker audio="alice-music-guitar-c-1.opus"> Да это же и правда бывший склад! Вы находите смачный шмат+ок сала и буханку хлеба!  Желаете откушать сейчас?", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/Ra6uCcxEhA88T6LP.jpg
        go!: /newNode_267
    @Transition
        {
          "boundsTo" : "/newNode_266",
          "then" : "/newNode_334"
        }
    state: newNode_267
        go!: /newNode_334
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Да",
                  "transition" : "/newNode_101"
                },
                {
                  "name" : "Нет",
                  "transition" : "/newNode_268"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_143"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_268",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "да"
                }
              ],
              "then" : "/newNode_101"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "Нет"
                },
                {
                  "type" : "example",
                  "value" : "неа"
                }
              ],
              "then" : "/newNode_268"
            }
          ]
        }
    state: newNode_334
        state: 1
            q: да

            go!: /newNode_101

        state: 2
            e: неа
            q: Нет

            go!: /newNode_268

        state: Fallback
            q: *
            go!: /newNode_268
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_334",
                name: "newNode_334 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Да"
                    , transition: "/newNode_101"
                    },
                    {text: "Нет"
                    , transition: "/newNode_268"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_143"
                    },
                  ]);
                }
            });

    state: newNode_143
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_144
    @Transition
        {
          "boundsTo" : "/newNode_143",
          "then" : "/newNode_334"
        }
    state: newNode_144
        go!: /newNode_334

    state: newNode_101
        if: $session.loot == "меч, сало";
            go!: /newNode_108
        elseif: $session.loot == "кость, меч, сало";
            go!: /newNode_109

    state: newNode_108
        if: $session.loot = "меч";
            go!: /newNode_110

    state: newNode_109
        if: $session.loot = "кость, меч";
            go!: /newNode_110

    state: newNode_110
        random:
            a: К вашему здоровью прибавилось +40%! || tts = "<speaker audio="alice-music-harp-1.opus"> Вкуснятина! К вашему здоровью прибавилось 40%", ttsEnabled = true
        if: $session.zd += 40;
            go!: /newNode_268

    state: newNode_268
        random:
            a: Куда отправимся дальше? || tts = "Куда отправимся дальше?", ttsEnabled = true
        go!: /newNode_269
    @Transition
        {
          "boundsTo" : "/newNode_268",
          "then" : "/newNode_306"
        }
    state: newNode_269
        go!: /newNode_306
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "сарай",
                  "transition" : "/newNode_96"
                },
                {
                  "name" : "цитадель",
                  "transition" : "/newNode_58"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_145"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_96",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "сарай"
                },
                {
                  "type" : "example",
                  "value" : "в сарай"
                }
              ],
              "then" : "/newNode_96"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "цитадель"
                },
                {
                  "type" : "example",
                  "value" : "в цитадель"
                }
              ],
              "then" : "/newNode_58"
            }
          ]
        }
    state: newNode_306
        state: 1
            e: в сарай
            q: сарай

            go!: /newNode_96

        state: 2
            e: в цитадель
            q: цитадель

            go!: /newNode_58

        state: Fallback
            q: *
            go!: /newNode_96
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_306",
                name: "newNode_306 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "сарай"
                    , transition: "/newNode_96"
                    },
                    {text: "цитадель"
                    , transition: "/newNode_58"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_145"
                    },
                  ]);
                }
            });

    state: newNode_145
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_146
    @Transition
        {
          "boundsTo" : "/newNode_145",
          "then" : "/newNode_306"
        }
    state: newNode_146
        go!: /newNode_306

    state: newNode_263
        if: $session.zd = 100;
            go!: /newNode_231

    state: newNode_270
        random:
            a: Дверь в сарай открывается со скрипом. Кровь в ваших жилах застывает. Бежать или драться ? || tts = "Дверь в сарай открывается со скрипом. Кровь в ваших жилах застывает. <speaker audio="alice-sounds-human-walking-dead-1.opus">Бежать или драться ?", ttsEnabled = true
        go!: /newNode_271
    @Transition
        {
          "boundsTo" : "/newNode_270",
          "then" : "/newNode_307"
        }
    state: newNode_271
        go!: /newNode_307
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "бежать",
                  "transition" : "/newNode_112"
                },
                {
                  "name" : "драться",
                  "transition" : "/newNode_219"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_147"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_219",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "драться"
                },
                {
                  "type" : "example",
                  "value" : "биться"
                },
                {
                  "type" : "example",
                  "value" : "дерись"
                }
              ],
              "then" : "/newNode_219"
            }
          ]
        }
    state: newNode_307
        state: 1
            e: драться
            e: биться
            e: дерись

            go!: /newNode_219

        state: Fallback
            q: *
            go!: /newNode_219
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_307",
                name: "newNode_307 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "бежать"
                    , transition: "/newNode_112"
                    },
                    {text: "драться"
                    , transition: "/newNode_219"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_147"
                    },
                  ]);
                }
            });

    state: newNode_147
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_148
    @Transition
        {
          "boundsTo" : "/newNode_147",
          "then" : "/newNode_307"
        }
    state: newNode_148
        go!: /newNode_307

    state: newNode_112
        random:
            a: Как только вы поворачиваетесь к зомби спиной, он прыгает на вас и вгрызается, отрывая куски мяса. Вы мертвы. Почти.Теперь вы тоже зомби! || tts = "<speaker audio="alice-sounds-human-laugh-3.opus"> Как только вы поворачиваетесь к зомби спиной, он прыгает на вас и вгрызается, отрывая куски мяса. Вы мертвы. Почти. Теперь вы тоже зомби!", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/CpORB2loCMg9Jwvn.jpg
        buttons:
            "Воскреснуть" -> /newNode_263
            {text: "Поставить оценку", url: "https://dialogs.yandex.ru/store/skills/deeb023c-citadel-chast-perva"}

    state: newNode_118
        random:
            a: Вам под руку попадается ведро и вы надеваете его на голову зомби. Вам показалось это хорошей идеей.  Бедолага бьется головой об стену. Вы задохнулись от приступа смеха. Попробуйте найти меч. || tts = "<speaker audio="alice-sounds-human-laugh-3.opus">Вы задохнулись от приступа смеха. Попробуйте найти меч.", ttsEnabled = true
        buttons:
            "Воскреснуть"
            {text: "Поставить оценку", url: "https://dialogs.yandex.ru/store/skills/deeb023c-citadel-chast-perva"}

    state: newNode_214
        random:
            a: Над вами кружатся и щебечут птички.  Вы в раю! || tts = "<speaker audio="alice-sounds-nature-forest-1.opus"> Вы мертвы, но Вы в раю!", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/UdPcwGac3FuZT6iR.jpg
        buttons:
            "Воскреснуть"
            {text: "Поставить оценку", url: "https://dialogs.yandex.ru/store/skills/deeb023c-citadel-chast-perva"}

    state: newNode_272
        random:
            a: Собрав все силы вы вынимаете меч из тела нежити и отрубаете ему голову!  Оказывается это не так сложно - драться с зомби. || tts = "<speaker audio="alice-sounds-game-win-3.opus"> Собрав все силы вы вынимаете меч из тела нежити и отрубаете ему голову!  Оказывается это не так сложно - драться с зомби.", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/DR0LyaCQxx0GVaNH.jpg
        go!: /newNode_273
    @Transition
        {
          "boundsTo" : "/newNode_272",
          "then" : "/newNode_211"
        }
    state: newNode_273
        go!: /newNode_211
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Войти в цитадель",
                  "transition" : "/newNode_58"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_149"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_58",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "войти в цитадель"
                },
                {
                  "type" : "pattern",
                  "value" : "идти в цитадель"
                },
                {
                  "type" : "pattern",
                  "value" : "цитадель"
                },
                {
                  "type" : "example",
                  "value" : "идти"
                }
              ],
              "then" : "/newNode_58"
            }
          ]
        }
    state: newNode_211
        state: 1
            e: идти
            q: войти в цитадель
            q: идти в цитадель
            q: цитадель

            go!: /newNode_58

        state: Fallback
            q: *
            go!: /newNode_58
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_211",
                name: "newNode_211 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Войти в цитадель"
                    , transition: "/newNode_58"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_149"
                    },
                  ]);
                }
            });

    state: newNode_96
        random:
            a: Дверь в сарай открывается со скрипом. Кровь в ваших жилах застывает. Бежать, орать или драться? || tts = "Дверь в сарай открывается со скрипом. Кровь в ваших жилах застывает. <speaker audio="alice-sounds-human-walking-dead-1.opus">Бежать, ор+ать или драться ?", ttsEnabled = true
        go!: /newNode_274
    @IntentGroup
        {
          "boundsTo" : "/newNode_96",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "бежать",
                  "transition" : "/newNode_117"
                },
                {
                  "name" : "драться",
                  "transition" : "/newNode_219"
                },
                {
                  "name" : "орать",
                  "transition" : "/newNode_120"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_120",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "Бежать"
                },
                {
                  "type" : "pattern",
                  "value" : "бежать"
                },
                {
                  "type" : "example",
                  "value" : "беги"
                }
              ],
              "then" : "/newNode_117"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "драться"
                },
                {
                  "type" : "example",
                  "value" : "дерись"
                },
                {
                  "type" : "example",
                  "value" : "бейся"
                }
              ],
              "then" : "/newNode_219"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "Орать"
                },
                {
                  "type" : "example",
                  "value" : "орать"
                },
                {
                  "type" : "pattern",
                  "value" : "кричать"
                },
                {
                  "type" : "example",
                  "value" : "наорать"
                }
              ],
              "then" : "/newNode_120"
            }
          ]
        }
    state: newNode_274
        state: 1
            e: беги
            q: Бежать
            q: бежать

            go!: /newNode_117

        state: 2
            e: дерись
            e: бейся
            q: драться

            go!: /newNode_219

        state: 3
            e: орать
            e: наорать
            q: Орать
            q: кричать

            go!: /newNode_120

        state: Fallback
            q: *
            go!: /newNode_120
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_274",
                name: "newNode_274 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "бежать"
                    , transition: "/newNode_117"
                    },
                    {text: "драться"
                    , transition: "/newNode_219"
                    },
                    {text: "орать"
                    , transition: "/newNode_120"
                    },
                  ]);
                }
            });

    state: newNode_117
        random:
            a: Как только вы поворачиваетесь к зомби спиной, он прыгает на вас и вгрызается, отрывая куски мяса. Вы мертвы. Почти. Теперь вы тоже зомби! || tts = "<speaker audio="alice-sounds-human-laugh-3.opus"> Как только вы поворачиваетесь к зомби спиной, он прыгает на вас и вгрызается, отрывая куски мяса. Вы мертвы. Почти. Теперь вы тоже зомби!", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/bUtRG8ZxQ6cqzrsF.jpg
        buttons:
            "Воскреснуть" -> /newNode_263
            {text: "Поставить оценку", url: "https://dialogs.yandex.ru/store/skills/deeb023c-citadel-chast-perva"}

    state: newNode_219
        if: $session.zd -= 60;
            go!: /newNode_119

    state: newNode_119
        if: $session.zd < 5;
            go!: /newNode_118
        else:
            go!: /newNode_276

    state: newNode_120
        if: $session.zd -= 5;
            go!: /newNode_213

    state: newNode_213
        if: $session.zd < 5;
            go!: /newNode_214
        else:
            go!: /newNode_121

    state: newNode_121
        random:
            a: Вы с ором вынимаете свой меч из ножен. C разбега вы прыгаете на зомби и втыкаете в него меч: Зомби в ярости толкает вас и вы ударяетесь головой об стену. Вы потеряли 5% здоровья. || tts = "Вы с +ором вынимаете свой меч из ножен и втыкаете его в зомби: Зомби в ярости толкает вас и вы ударяетесь головой об стену. Вы потеряли 5% здоровья. <speaker audio="alice-sounds-game-loss-3.opus">", ttsEnabled = true
        go!: /newNode_305
    @IntentGroup
        {
          "boundsTo" : "/newNode_121",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Драться",
                  "transition" : "/newNode_272"
                },
                {
                  "name" : "Бежать",
                  "transition" : "/newNode_117"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_272",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "Драться"
                },
                {
                  "type" : "example",
                  "value" : "драться"
                },
                {
                  "type" : "example",
                  "value" : "дерись"
                }
              ],
              "then" : "/newNode_272"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "Бежать"
                },
                {
                  "type" : "example",
                  "value" : "бежать"
                },
                {
                  "type" : "example",
                  "value" : "беги"
                }
              ],
              "then" : "/newNode_117"
            }
          ]
        }
    state: newNode_305
        state: 1
            e: драться
            e: дерись
            q: Драться

            go!: /newNode_272

        state: 2
            e: бежать
            e: беги
            q: Бежать

            go!: /newNode_117

        state: Fallback
            q: *
            go!: /newNode_272
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_305",
                name: "newNode_305 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Драться"
                    , transition: "/newNode_272"
                    },
                    {text: "Бежать"
                    , transition: "/newNode_117"
                    },
                  ]);
                }
            });

    state: newNode_149
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_150
    @Transition
        {
          "boundsTo" : "/newNode_149",
          "then" : "/newNode_211"
        }
    state: newNode_150
        go!: /newNode_211

    state: newNode_276
        random:
            a: Вы нашли ведро и надеваете его на голову зомби. Бедолага бьется головой об стену. Вы задыхаетесь от приступа смеха и теряете 60% здоровья. || tts = "<speaker audio="alice-sounds-human-laugh-4.opus"> Вы нашли ведро и надеваете его на голову зомби. Бедолага бьется головой об стену. Вы задыхаетесь от приступа смеха и теряете 60% здоровья.", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/3ibVhd1mxC49RVsM.jpg
        go!: /newNode_277
    @Transition
        {
          "boundsTo" : "/newNode_276",
          "then" : "/newNode_335"
        }
    state: newNode_277
        go!: /newNode_335
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Идти в цитадель",
                  "transition" : "/newNode_58"
                },
                {
                  "name" : "рюкзак",
                  "transition" : "/newNode_215"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_58",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "идти"
                }
              ],
              "then" : "/newNode_58"
            }
          ]
        }
    state: newNode_335
        state: 1
            q: идти

            go!: /newNode_58

        state: Fallback
            q: *
            go!: /newNode_58
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_335",
                name: "newNode_335 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Идти в цитадель"
                    , transition: "/newNode_58"
                    },
                    {text: "рюкзак"
                    , transition: "/newNode_215"
                    },
                  ]);
                }
            });

    state: newNode_215
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_217
    @Transition
        {
          "boundsTo" : "/newNode_215",
          "then" : "/newNode_335"
        }
    state: newNode_217
        go!: /newNode_335

    state: newNode_58
        if: $session.loot == "пусто";
            go!: /newNode_278
        elseif: $session.loot == "меч";
            go!: /newNode_278
        elseif: $session.loot == "меч, сало";
            go!: /newNode_278
        elseif: $session.loot == "кость";
            go!: /newNode_280
        elseif: $session.loot == "кость, меч";
            go!: /newNode_280
        elseif: $session.loot == "кость, меч, сало";
            go!: /newNode_280
        elseif: $session.loot == "сало";
            go!: /newNode_278
        elseif: $session.loot == "кость, сало";
            go!: /newNode_280
        else:
            go!: /newNode_280

    state: newNode_278
        random:
            a: Вы оказались у двери цитадели, но вход охраняется странным маленьким псом. Как думаете, он вас пропустит? || tts = "<speaker audio="alice-sounds-animals-dog-1.opus"> Вы оказались у двери цитадели, но вход охраняется странным маленьким псом. Как думаете, он вас пропустит?", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/PVKgVZAlZOCZzyHS.jpg
        go!: /newNode_279
    @Transition
        {
          "boundsTo" : "/newNode_278",
          "then" : "/newNode_66"
        }
    state: newNode_279
        go!: /newNode_66
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Бежать к двери",
                  "transition" : "/newNode_76"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_68"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_76",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "бежать к двери"
                }
              ],
              "then" : "/newNode_76"
            }
          ]
        }
    state: newNode_66
        state: 1
            e: бежать к двери

            go!: /newNode_76

        state: Fallback
            q: *
            go!: /newNode_76
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_66",
                name: "newNode_66 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Бежать к двери"
                    , transition: "/newNode_76"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_68"
                    },
                  ]);
                }
            });

    state: newNode_68
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_69
    @Transition
        {
          "boundsTo" : "/newNode_68",
          "then" : "/newNode_66"
        }
    state: newNode_69
        go!: /newNode_66

    state: newNode_280
        random:
            a: Вы оказались у двери цитадели, но вход охраняется странным маленьким псом. Как думаете, он вас пропустит? || tts = "<speaker audio="alice-sounds-animals-dog-1.opus"> Вы оказались у двери цитадели, но вход охраняется странным маленьким псом. Как думаете, он вас пропустит?", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/toGhDHMVhIc3Mp3W.jpg
        go!: /newNode_281
    @Transition
        {
          "boundsTo" : "/newNode_280",
          "then" : "/newNode_67"
        }
    state: newNode_281
        go!: /newNode_67
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Кинуть кость",
                  "transition" : "/newNode_73"
                },
                {
                  "name" : "Бежать к двери",
                  "transition" : "/newNode_76"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_70"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_73",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "бежать к двери"
                }
              ],
              "then" : "/newNode_76"
            }
          ]
        }
    state: newNode_67
        state: 1
            e: бежать к двери

            go!: /newNode_76

        state: Fallback
            q: *
            go!: /newNode_73
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_67",
                name: "newNode_67 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Кинуть кость"
                    , transition: "/newNode_73"
                    },
                    {text: "Бежать к двери"
                    , transition: "/newNode_76"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_70"
                    },
                  ]);
                }
            });

    state: newNode_70
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_71
    @Transition
        {
          "boundsTo" : "/newNode_70",
          "then" : "/newNode_67"
        }
    state: newNode_71
        go!: /newNode_67

    state: newNode_76
        if: $session.zd -= 45;
            go!: /newNode_123
        else:
            go!: /newNode_123

    state: newNode_123
        if: $session.zd < 5;
            go!: /newNode_124
        else:
            go!: /newNode_75

    state: newNode_124
        random:
            a: Вас растерзал чихуа-хуа. Попробуйте найти кость или съесть сало перед боем. || tts = "<speaker audio="alice-sounds-animals-dog-4.opus"> Вас растерзал чихуа-хуа. Попробуйте найти кость или съесть сало перед боем.", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/Gg8u7Dvnf4k3Euar.jpg
        buttons:
            "Воскреснуть" -> /newNode_327
            {text: "Поставить оценку", url: "https://dialogs.yandex.ru/store/skills/deeb023c-citadel-chast-perva"}

    state: newNode_327
        if: $session.zd = 100;
            go!: /newNode_254

    state: newNode_73
        random:
            a: Пес жадно набросился на кость и вы успели прыгнуть за дверь.
        go!: /newNode_74
    @Transition
        {
          "boundsTo" : "/newNode_73",
          "then" : "/newNode_125"
        }
    state: newNode_74
        go!: /newNode_125

    state: newNode_125
        if: $session.loot == "кость, меч, сало";
            go!: /newNode_126
        elseif: $session.loot == "кость, меч";
            go!: /newNode_127
        elseif: $session.loot == "пусто";
            go!: /newNode_284
        elseif: $session.loot == "кость";
            go!: /newNode_202
        elseif: $session.loot == "кость, сало";
            go!: /newNode_222

    state: newNode_202
        if: $session.loot = "пусто";
            go!: /newNode_284

    state: newNode_126
        if: $session.loot = "меч, сало";
            go!: /newNode_282

    state: newNode_127
        if: $session.loot = "меч";
            go!: /newNode_284

    state: newNode_222
        if: $session.loot = "сало";
            go!: /newNode_128

    state: newNode_75
        random:
            a: Вас покусал пёс, но вы проникли внутрь, потеряв 45% здоровья. || tts = "<speaker audio="alice-music-gong-2.opus">Вас покусал пёс, но вы проникли внутрь, потеряв 45% здоровья.", ttsEnabled = true
        go!: /newNode_77
    @Transition
        {
          "boundsTo" : "/newNode_75",
          "then" : "/newNode_128"
        }
    state: newNode_77
        go!: /newNode_128

    state: newNode_128
        if: $session.loot == "меч, сало";
            go!: /newNode_282
        elseif: $session.loot == "меч";
            go!: /newNode_284
        elseif: $session.loot == "кость, меч";
            go!: /newNode_284
        elseif: $session.loot == "кость, меч, сало";
            go!: /newNode_282
        elseif: $session.loot == "пусто";
            go!: /newNode_284
        elseif: $session.loot == "сало";
            go!: /newNode_282
        elseif: $session.loot == "кость";
            go!: /newNode_284
        else:
            go!: /newNode_282

    state: newNode_282
        random:
            a: Вы очутились в тёмном, длинном коридоре.  Впереди - широкая, деревянная лестница. || tts = "Вы очутились в тёмном, длинном коридоре.  Впереди - широкая, деревянная лестница.", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/lqoNAXe2EHFyU5L5.jpg
        go!: /newNode_283
    @Transition
        {
          "boundsTo" : "/newNode_282",
          "then" : "/newNode_80"
        }
    state: newNode_283
        go!: /newNode_80
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_78"
                },
                {
                  "name" : "есть сало",
                  "transition" : "/newNode_151"
                },
                {
                  "name" : "идти по лестнице",
                  "transition" : "/newNode_286"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_286",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "съесть сало"
                },
                {
                  "type" : "pattern",
                  "value" : "сало"
                },
                {
                  "type" : "example",
                  "value" : "есть сало"
                }
              ],
              "then" : "/newNode_151"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "лестница"
                },
                {
                  "type" : "example",
                  "value" : "идти по лестнице"
                },
                {
                  "type" : "example",
                  "value" : "идти"
                }
              ],
              "then" : "/newNode_286"
            }
          ]
        }
    state: newNode_80
        state: 1
            e: есть сало
            q: съесть сало
            q: сало

            go!: /newNode_151

        state: 2
            e: идти по лестнице
            e: идти
            q: лестница

            go!: /newNode_286

        state: Fallback
            q: *
            go!: /newNode_286
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_80",
                name: "newNode_80 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Рюкзак"
                    , transition: "/newNode_78"
                    },
                    {text: "есть сало"
                    , transition: "/newNode_151"
                    },
                    {text: "идти по лестнице"
                    , transition: "/newNode_286"
                    },
                  ]);
                }
            });

    state: newNode_78
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_79
    @Transition
        {
          "boundsTo" : "/newNode_78",
          "then" : "/newNode_80"
        }
    state: newNode_79
        go!: /newNode_80

    state: newNode_284
        random:
            a: Вы очутились в тёмном, длинном коридоре с деревянной лестницей чуть поодаль. Поднимаемся? || tts = "Вы очутились в тёмном коридоре с лестницей. Поднимаемся?", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/gnXjLllU8bNYeiQp.jpg
        go!: /newNode_285
    @Transition
        {
          "boundsTo" : "/newNode_284",
          "then" : "/newNode_336"
        }
    state: newNode_285
        go!: /newNode_336
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_132"
                },
                {
                  "name" : "идти по лестнице",
                  "transition" : "/newNode_286"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_286",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "подняться"
                }
              ],
              "then" : "/newNode_286"
            }
          ]
        }
    state: newNode_336
        state: 1
            q: подняться

            go!: /newNode_286

        state: Fallback
            q: *
            go!: /newNode_286
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_336",
                name: "newNode_336 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Рюкзак"
                    , transition: "/newNode_132"
                    },
                    {text: "идти по лестнице"
                    , transition: "/newNode_286"
                    },
                  ]);
                }
            });

    state: newNode_132
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_133
    @Transition
        {
          "boundsTo" : "/newNode_132",
          "then" : "/newNode_336"
        }
    state: newNode_133
        go!: /newNode_336

    state: newNode_151
        if: $session.loot == "меч, сало";
            go!: /newNode_152
        elseif: $session.loot == "сало";
            go!: /newNode_223
        elseif: $session.loot == "кость, меч, сало";
            go!: /newNode_347
        else:
            go!: /newNode_223

    state: newNode_152
        if: $session.loot = "меч";
            go!: /newNode_153

    state: newNode_223
        if: $session.loot ="пусто";
            go!: /newNode_153

    state: newNode_347
        if: $session.loot = "кость, меч";
            go!: /newNode_153

    state: newNode_153
        random:
            a: Вкуснотища! Ваше здоровье улучшилось! || tts = "<speaker audio="alice-music-harp-1.opus">Вкуснотища! Ваше здоровье улучшилось!", ttsEnabled = true
        go!: /newNode_155
    @Transition
        {
          "boundsTo" : "/newNode_153",
          "then" : "/newNode_154"
        }
    state: newNode_155
        go!: /newNode_154

    state: newNode_154
        if: $session.zd += 40;
            go!: /newNode_286

    state: newNode_286
        random:
            a: Поднявшись по лестнице, вы заметили что,  перед вами копошится грязный, рычащий человек. Он доедает что-то вонючее ... || tts = "<speaker audio="alice-sounds-human-walking-dead-3.opus">Поднявшись по лестнице, вы заметили что,  перед вами копошится грязный, рычащий человек. Он доедает что-то вонючее ...", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/CLV9YY0TdbsxIvTd.jpg
        go!: /newNode_287
    @Transition
        {
          "boundsTo" : "/newNode_286",
          "then" : "/newNode_240"
        }
    state: newNode_287
        go!: /newNode_240
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Атаковать ",
                  "transition" : "/newNode_206"
                },
                {
                  "name" : "Притвориться мертвым",
                  "transition" : "/newNode_159"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_157"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_206",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "притвориться мертвым"
                },
                {
                  "type" : "pattern",
                  "value" : "мертвый"
                }
              ],
              "then" : "/newNode_159"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "Атаковать"
                },
                {
                  "type" : "example",
                  "value" : "атаковать"
                },
                {
                  "type" : "example",
                  "value" : "атакуй"
                }
              ],
              "then" : "/newNode_206"
            }
          ]
        }
    state: newNode_240
        state: 1
            q: притвориться мертвым
            q: мертвый

            go!: /newNode_159

        state: 2
            e: атаковать
            e: атакуй
            q: Атаковать

            go!: /newNode_206

        state: Fallback
            q: *
            go!: /newNode_206
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_240",
                name: "newNode_240 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Атаковать "
                    , transition: "/newNode_206"
                    },
                    {text: "Притвориться мертвым"
                    , transition: "/newNode_159"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_157"
                    },
                  ]);
                }
            });

    state: newNode_157
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_158
    @Transition
        {
          "boundsTo" : "/newNode_157",
          "then" : "/newNode_240"
        }
    state: newNode_158
        go!: /newNode_240

    state: newNode_159
        random:
            a: Вы решили притвориться мертвым, и даже приняли позу  опоссума, но вас выдал напавший внезапно кашель, и вы были съедены. || tts = "<speaker audio="alice-sounds-game-loss-2.opus"> <speaker effect="hamster">Вы решили притвориться мертвым, и даже приняли позу  опоссума, но вас выдал напавший внезапно кашель, и вы были съедены.", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/VfvfpWWGUmnxkObX.jpg
        buttons:
            "Воскреснуть"
            {text: "Поставить оценку", url: "https://dialogs.yandex.ru/store/skills/deeb023c-citadel-chast-perva"}

    state: newNode_206
        if: $session.loot == "меч, сало";
            go!: /newNode_160
        elseif: $session.loot == "меч";
            go!: /newNode_160
        elseif: $session.loot == "сало";
            go!: /newNode_218
        elseif: $session.loot == "пусто";
            go!: /newNode_218
        elseif: $session.loot == "кость, меч, сало";
            go!: /newNode_160
        elseif: $session.loot == "кость, меч";
            go!: /newNode_160
        elseif: $session.loot == "кость, сало";
            go!: /newNode_218
        elseif: $session.loot == "кость";
            go!: /newNode_218
        else:
            go!: /newNode_218

    state: newNode_218
        random:
            a: Серьезно?! Хотели напугать зомби шматком сала? Вы мертвы. Попробуйте найти меч. || tts = "<speaker audio="alice-sounds-human-laugh-3.opus">Серьезно?! Хотели напугать зомби шматк+ом сала?! Вы мертвы. Попробуйте найти меч.", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/dKyepWn9TZhR9uVK.jpg
        buttons:
            "воскреснуть" -> /newNode_224
            {text: "Поставить оценку", url: "https://dialogs.yandex.ru/store/skills/deeb023c-citadel-chast-perva"}

    state: newNode_160
        random:
            a: Вы с криком напали на жующего зомби. Мертвец подавился и запустил в вас чьей-то ногой.  Ваше здоровье уменьшилось на 60%.
        go!: /newNode_164
    @Transition
        {
          "boundsTo" : "/newNode_160",
          "then" : "/newNode_161"
        }
    state: newNode_164
        go!: /newNode_161

    state: newNode_161
        if: $session.zd -= 60;
            go!: /newNode_162
        else:
            go!: /newNode_162

    state: newNode_162
        if: $session.zd < 5;
            go!: /newNode_163
        else:
            go!: /newNode_314

    state: newNode_163
        random:
            a: Вы умерли от запущенной в вас ноги. Попробуйте избежать других повреждений перед боем. || tts = "<speaker audio="alice-sounds-game-loss-2.opus">Вы умерли от запущенной в вас ноги. Попробуйте избежать других повреждений перед боем.", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/fwzNPSYPEpnhHqh0.jpg
        buttons:
            "Воскреснуть"
            {text: "Поставить оценку", url: "https://dialogs.yandex.ru/store/skills/deeb023c-citadel-chast-perva"}

    state: newNode_314
        random:
            a: Монстр в ярости. Что будем делать?
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/HyyPXdaL64r98sgS.jpg
        go!: /newNode_315
    @Transition
        {
          "boundsTo" : "/newNode_314",
          "then" : "/newNode_316"
        }
    state: newNode_315
        go!: /newNode_316
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "кричать",
                  "transition" : "/newNode_318"
                },
                {
                  "name" : "драться",
                  "transition" : "/newNode_292"
                },
                {
                  "name" : "рюкзак",
                  "transition" : "/newNode_313"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_292",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "кричать"
                },
                {
                  "type" : "example",
                  "value" : "орать"
                }
              ],
              "then" : "/newNode_318"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "драться"
                },
                {
                  "type" : "example",
                  "value" : "биться"
                }
              ],
              "then" : "/newNode_292"
            }
          ]
        }
    state: newNode_316
        state: 1
            e: орать
            q: кричать

            go!: /newNode_318

        state: 2
            e: биться
            q: драться

            go!: /newNode_292

        state: Fallback
            q: *
            go!: /newNode_292
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_316",
                name: "newNode_316 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "кричать"
                    , transition: "/newNode_318"
                    },
                    {text: "драться"
                    , transition: "/newNode_292"
                    },
                    {text: "рюкзак"
                    , transition: "/newNode_313"
                    },
                  ]);
                }
            });

    state: newNode_313
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_317
    @Transition
        {
          "boundsTo" : "/newNode_313",
          "then" : "/newNode_316"
        }
    state: newNode_317
        go!: /newNode_316

    state: newNode_318
        random:
            a: Вы бегаете и орёте на зомби, зомби бегает и орёт на вас. На это можно смотреть вечно...
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/u1176H4AcfKZHh8A.jpg
        go!: /newNode_319
    @Transition
        {
          "boundsTo" : "/newNode_318",
          "then" : "/newNode_316"
        }
    state: newNode_319
        go!: /newNode_316

    state: newNode_292
        random:
            a: Собравшись с силами вы нанесли зомби два удара мечом и покромсали мертвеца в соломку! Да, вы, сударь - мясник? || tts = "<speaker audio="alice-sounds-game-win-1.opus"> Собравшись с силами вы  покромс+али мертвеца в соломку! Да, вы, сударь - мясник?!", ttsEnabled = true
        go!: /newNode_293
    @Transition
        {
          "boundsTo" : "/newNode_292",
          "then" : "/newNode_169"
        }
    state: newNode_293
        go!: /newNode_169
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Обыскать труп",
                  "transition" : "/newNode_173"
                },
                {
                  "name" : "Осмотреться",
                  "transition" : "/newNode_290"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_167"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_290",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "обыскать труп"
                },
                {
                  "type" : "example",
                  "value" : "труп"
                }
              ],
              "then" : "/newNode_173"
            },
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "осмотреться"
                },
                {
                  "type" : "example",
                  "value" : "асмотреться"
                }
              ],
              "then" : "/newNode_290"
            }
          ]
        }
    state: newNode_169
        state: 1
            e: обыскать труп
            e: труп

            go!: /newNode_173

        state: 2
            e: осмотреться
            e: асмотреться

            go!: /newNode_290

        state: Fallback
            q: *
            go!: /newNode_290
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_169",
                name: "newNode_169 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Обыскать труп"
                    , transition: "/newNode_173"
                    },
                    {text: "Осмотреться"
                    , transition: "/newNode_290"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_167"
                    },
                  ]);
                }
            });

    state: newNode_167
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_168
    @Transition
        {
          "boundsTo" : "/newNode_167",
          "then" : "/newNode_169"
        }
    state: newNode_168
        go!: /newNode_169

    state: newNode_173
        if: $session.loot += " пахучий пузырёк";
            go!: /newNode_288

    state: newNode_288
        random:
            a: В карманах мертвеца оказался пузырёк с чем-то пахучим. Наверное, мускус. || tts = "\n<speaker audio="alice-music-guitar-e-1.opus"> В карманах мертвеца оказался пузырёк с чэм-то пахучим. Наверное, м+ускус.", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/4OLjCfgONjFKMlM4.jpg
        go!: /newNode_289
    @Transition
        {
          "boundsTo" : "/newNode_288",
          "then" : "/newNode_349"
        }
    state: newNode_289
        go!: /newNode_349
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Осмотреться",
                  "transition" : "/newNode_290"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_175"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_290",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "осмотреться"
                }
              ],
              "then" : "/newNode_290"
            }
          ]
        }
    state: newNode_349
        state: 1
            e: осмотреться

            go!: /newNode_290

        state: Fallback
            q: *
            go!: /newNode_290
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_349",
                name: "newNode_349 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Осмотреться"
                    , transition: "/newNode_290"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_175"
                    },
                  ]);
                }
            });

    state: newNode_175
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_176
    @Transition
        {
          "boundsTo" : "/newNode_175",
          "then" : "/newNode_349"
        }
    state: newNode_176
        go!: /newNode_349

    state: newNode_290
        random:
            a: Комната пахнет ладаном и сыростью.  В глубине виднеется массивная дверь. Кажется, вы слышите знакомые звуки со стороны сундука. || tts = "Комната пахнет ладаном и сыростью.  В глубине виднеется массивная дверь. Вы слышите звуки со стороны сундука.<speaker audio="alice-sounds-animals-cat-2.opus">", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/sUx7yy7xSL90E8ou.jpg
        go!: /newNode_291
    @Transition
        {
          "boundsTo" : "/newNode_290",
          "then" : "/newNode_337"
        }
    state: newNode_291
        go!: /newNode_337
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Открыть дверь ",
                  "transition" : "/newNode_179"
                },
                {
                  "name" : "Найти кота",
                  "transition" : "/newNode_183"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_171"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_179",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "Открыть дверь"
                },
                {
                  "type" : "example",
                  "value" : "дверь"
                },
                {
                  "type" : "example",
                  "value" : "открыть дверь"
                }
              ],
              "then" : "/newNode_179"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "найти кота"
                },
                {
                  "type" : "example",
                  "value" : "искать кота"
                },
                {
                  "type" : "example",
                  "value" : "кот"
                }
              ],
              "then" : "/newNode_183"
            }
          ]
        }
    state: newNode_337
        state: 1
            e: дверь
            e: открыть дверь
            q: Открыть дверь

            go!: /newNode_179

        state: 2
            e: искать кота
            e: кот
            q: найти кота

            go!: /newNode_183

        state: Fallback
            q: *
            go!: /newNode_179
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_337",
                name: "newNode_337 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Открыть дверь "
                    , transition: "/newNode_179"
                    },
                    {text: "Найти кота"
                    , transition: "/newNode_183"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_171"
                    },
                  ]);
                }
            });

    state: newNode_171
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_172
    @Transition
        {
          "boundsTo" : "/newNode_171",
          "then" : "/newNode_337"
        }
    state: newNode_172
        go!: /newNode_337

    state: newNode_179
        random:
            a: Дверь не поддаётся. Наверное, нужен ключ. || tts = "<speaker audio="alice-sounds-game-boot-1.opus">Дверь не поддаётся. Наверное, нужен ключ.", ttsEnabled = true
        go!: /newNode_180
    @Transition
        {
          "boundsTo" : "/newNode_179",
          "then" : "/newNode_337"
        }
    state: newNode_180
        go!: /newNode_337

    state: newNode_183
        if: $session.loot == "меч пахучий пузырёк";
            go!: /newNode_296
        elseif: $session.loot == "кость, меч пахучий пузырёк";
            go!: /newNode_296
        elseif: $session.loot == "кость, меч, сало пахучий пузырёк";
            go!: /newNode_296
        elseif: $session.loot == "меч, сало пахучий пузырёк";
            go!: /newNode_296
        else:
            go!: /newNode_294

    state: newNode_294
        random:
            a: На кованом сундуке лежит огромный, ленивый кот. Кажется, с блохами. || tts = "\n<speaker audio="alice-sounds-animals-cat-4.opus">На кованом сундуке лежит огромный, ленивый кот. Кажется, с бл+охами.", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/QFlXFGWTrp6hovYY.jpg
        go!: /newNode_295
    @Transition
        {
          "boundsTo" : "/newNode_294",
          "then" : "/newNode_338"
        }
    state: newNode_295
        go!: /newNode_338
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "погладить",
                  "transition" : "/newNode_343"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_184"
                },
                {
                  "name" : "поговорить",
                  "transition" : "/newNode_321"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_343",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "погладить"
                },
                {
                  "type" : "example",
                  "value" : "гладить кота"
                },
                {
                  "type" : "example",
                  "value" : "погладить кота"
                }
              ],
              "then" : "/newNode_343"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "поговорить"
                },
                {
                  "type" : "pattern",
                  "value" : "разговаривать"
                },
                {
                  "type" : "example",
                  "value" : "поговорить с котом"
                }
              ],
              "then" : "/newNode_321"
            }
          ]
        }
    state: newNode_338
        state: 1
            e: гладить кота
            e: погладить кота
            q: погладить

            go!: /newNode_343

        state: 2
            e: поговорить с котом
            q: поговорить
            q: разговаривать

            go!: /newNode_321

        state: Fallback
            q: *
            go!: /newNode_343
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_338",
                name: "newNode_338 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "погладить"
                    , transition: "/newNode_343"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_184"
                    },
                    {text: "поговорить"
                    , transition: "/newNode_321"
                    },
                  ]);
                }
            });

    state: newNode_184
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_185
    @Transition
        {
          "boundsTo" : "/newNode_184",
          "then" : "/newNode_338"
        }
    state: newNode_185
        go!: /newNode_338

    state: newNode_343
        random:
            a: Кот ощетинился, спрыгнул с сундука,  и,  нещадно матерясь убежал куда-то в темноту. Наверное, нужно обыскать комнату в поисках кошачьих лакомств. || tts = "<speaker audio="alice-sounds-animals-cat-5.opus">Кот ощетинился, спрыгнул с сундука,  и,  нещадно матерясь убежал куда-то в темноту. Наверное, нужно обыскать комнату в поисках кошачьих лакомств.", ttsEnabled = true
        go!: /newNode_344
    @Transition
        {
          "boundsTo" : "/newNode_343",
          "then" : "/newNode_345"
        }
    state: newNode_344
        go!: /newNode_345
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Обыскать зомби",
                  "transition" : "/newNode_173"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_342"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_173",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "обыскать зомби"
                },
                {
                  "type" : "example",
                  "value" : "Обыскать зомби"
                }
              ],
              "then" : "/newNode_173"
            }
          ]
        }
    state: newNode_345
        state: 1
            e: Обыскать зомби
            q: обыскать зомби

            go!: /newNode_173

        state: Fallback
            q: *
            go!: /newNode_173
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_345",
                name: "newNode_345 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Обыскать зомби"
                    , transition: "/newNode_173"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_342"
                    },
                  ]);
                }
            });

    state: newNode_342
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_346
    @Transition
        {
          "boundsTo" : "/newNode_342",
          "then" : "/newNode_345"
        }
    state: newNode_346
        go!: /newNode_345

    state: newNode_321
        if: $session.zd -= 5;
            go!: /newNode_323
        else:
            go!: /newNode_323

    state: newNode_323
        if: $session.zd < 5;
            go!: /newNode_324
        else:
            go!: /newNode_320

    state: newNode_320
        random:
            a: Говорящих котов не бывает! От расстройства вы теряете 5% здоровья.
        go!: /newNode_322
    @Transition
        {
          "boundsTo" : "/newNode_320",
          "then" : "/newNode_338"
        }
    state: newNode_322
        go!: /newNode_338

    state: newNode_324
        random:
            a: Нелепая смерть от разочарования.
        buttons:
            "Воскреснуть" -> /newNode_224
            {text: "Поставить оценку", url: "https://dialogs.yandex.ru/store/skills/deeb023c-citadel-chast-perva"}

    state: newNode_296
        random:
            a: На кованом сундуке лежит огромный, ленивый кот.  Завидев вас, кот начинает вести носом и принимает деловой вид: "Ты наверное, {{$session.name}}? || tts = "<speaker audio="alice-sounds-animals-cat-4.opus"> Завидев вас, кот начинает вести носом и принимает деловой вид: "Ты наверное, {{$session.name}}?", ttsEnabled = true
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/jIlBQoR4Ki9lsRcI.jpg
        go!: /newNode_297
    @Transition
        {
          "boundsTo" : "/newNode_296",
          "then" : "/newNode_187"
        }
    state: newNode_297
        go!: /newNode_187
    @InputText
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "хочу домой",
                  "transition" : "/newNode_188"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_196"
                }
              ]
            }
          ],
          "prompt" : "Чего тебе от меня нужно?\"",
          "varName" : "text3",
          "then" : "/newNode_188"
        }
    state: newNode_187 || modal = true
        a: Чего тебе от меня нужно?"

        state:
            q: * *start *
            script:
              Zenflow.start();

        state: CatchText
            q: *
            script:
                addClientVarToSession("text3", $parseTree.text);
            go!: /newNode_188
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_187",
                name: "newNode_187 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "хочу домой"
                    , transition: "/newNode_188"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_196"
                    },
                  ]);
                }
            });

    state: newNode_196
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}.
        go!: /newNode_197
    @Transition
        {
          "boundsTo" : "/newNode_196",
          "then" : "/newNode_187"
        }
    state: newNode_197
        go!: /newNode_187

    state: newNode_188
        random:
            a: "Мне кажется, у тебя есть кое-что для меня интересное... Отдай мне это." Глаза кота страшно сверкнули. || tts = "Мне кажется, у тебя есть кое-что для меня интересное... Отдай мне это!", ttsEnabled = true
        go!: /newNode_189
    @InputText
        {
          "boundsTo" : "/newNode_188",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Отдать валерьянку коту",
                  "transition" : "/newNode_191"
                }
              ]
            }
          ],
          "prompt" : "Возможно, я смогу тебе помочь.",
          "varName" : "text5",
          "then" : "/newNode_191"
        }
    state: newNode_189 || modal = true
        a: Возможно, я смогу тебе помочь.

        state:
            q: * *start *
            script:
              Zenflow.start();

        state: CatchText
            q: *
            script:
                addClientVarToSession("text5", $parseTree.text);
            go!: /newNode_191
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_189",
                name: "newNode_189 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Отдать валерьянку коту"
                    , transition: "/newNode_191"
                    },
                  ]);
                }
            });

    state: newNode_191
        if: $session.loot == "кость, меч, сало пахучий пузырёк";
            go!: /newNode_339
        elseif: $session.loot == "меч, сало пахучий пузырёк";
            go!: /newNode_340
        elseif: $session.loot == "меч пахучий пузырёк";
            go!: /newNode_341
        else:
            go!: /newNode_298

    state: newNode_339
        if: $session.loot = "кость, меч, сало, ключ";
            go!: /newNode_298

    state: newNode_340
        if: $session.loot = "меч, сало, ключ";
            go!: /newNode_298

    state: newNode_341
        if: $session.loot = "меч, ключ";
            go!: /newNode_298

    state: newNode_298
        random:
            a: "Так и быть ... держи ключик. Тебе - туда"
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/oB7CKOcyYNnoW0yy.jpg
        go!: /newNode_299
    @Transition
        {
          "boundsTo" : "/newNode_298",
          "then" : "/newNode_348"
        }
    state: newNode_299
        go!: /newNode_348
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Открыть дверь",
                  "transition" : "/newNode_194"
                },
                {
                  "name" : "Рюкзак",
                  "transition" : "/newNode_192"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_194",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "Открыть дверь"
                },
                {
                  "type" : "example",
                  "value" : "открыть дверь"
                },
                {
                  "type" : "example",
                  "value" : "дверь"
                }
              ],
              "then" : "/newNode_194"
            }
          ]
        }
    state: newNode_348
        state: 1
            e: открыть дверь
            e: дверь
            q: Открыть дверь

            go!: /newNode_194

        state: Fallback
            q: *
            go!: /newNode_194
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_348",
                name: "newNode_348 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Открыть дверь"
                    , transition: "/newNode_194"
                    },
                    {text: "Рюкзак"
                    , transition: "/newNode_192"
                    },
                  ]);
                }
            });

    state: newNode_192
        random:
            a: Здоровье  - {{$session.zd}} %,  в рюкзаке -  {{$session.loot}}, ключ.
        go!: /newNode_193
    @Transition
        {
          "boundsTo" : "/newNode_192",
          "then" : "/newNode_348"
        }
    state: newNode_193
        go!: /newNode_348

    state: newNode_194
        image: https://248305.selcdn.ru/zfl_prod/81762080/81762083/3qWMXr1YS1jcIzGL.jpg
        random:
            a:  Поздравляем! Вы снова мертвы, но прошли первую часть игры!
                Поддержите автора донатом на корм котейке! 👇🏻 || tts = "<speaker audio="alice-music-bagpipes-1.opus"> Поздравляем! Вы снова мертвы, но прошли первую часть игр+ы!\nПоддержите автора донатом на корм котейке!", ttsEnabled = true
        go!: /newNode_354
    @IntentGroup
        {
          "boundsTo" : "/newNode_194",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "продолжение истории",
                  "url" : "https://alice.ya.ru/s/64791e8a-7af0-4918-a5f9-168fb08558b2"
                },
                {
                  "name" : "Котейке на корм",
                  "url" : "https://dialogs.yandex.ru/store/skills/deeb023c-citadel-chast-perva?action=donation"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_194",
          "intents" : [ ]
        }
    state: newNode_354
        state: Fallback
            q: *
            go!: /newNode_194
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_354",
                name: "newNode_354 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "продолжение истории"
                    , url: "https://alice.ya.ru/s/64791e8a-7af0-4918-a5f9-168fb08558b2"
                    },
                    {text: "Котейке на корм"
                    , url: "https://dialogs.yandex.ru/store/skills/deeb023c-citadel-chast-perva?action=donation"
                    },
                  ]);
                }
            });
