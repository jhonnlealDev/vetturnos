const READING_CONTENT = [
  {
    type: 'intro',
    title: 'Introducción',
    paragraphs: [
      'Cuando una persona decide aprender programación, muchas veces cree que programar consiste únicamente en escribir código en una pantalla negra llena de símbolos extraños.',
      'Sin embargo, la realidad es muy diferente. Programar es aprender a resolver problemas utilizando tecnología.',
      'Un desarrollador de software es, en esencia, un constructor de soluciones. Así como un arquitecto construye edificios y un médico ayuda a sanar personas, un desarrollador construye sistemas que ayudan a resolver necesidades del mundo real.',
      'Hoy vivimos una época fascinante. Nunca antes en la historia una sola persona había tenido acceso a tantas herramientas tecnológicas. Gracias a la Inteligencia Artificial, un desarrollador puede construir en semanas lo que hace algunos años requería equipos completos de trabajo.',
      'Pero para aprovechar estas herramientas primero debemos comprender los fundamentos.'
    ]
  },
  {
    type: 'analogy',
    title: 'Imagina que vas a construir una casa',
    paragraphs: [
      'Supongamos que mañana te entregan un terreno vacío y te dicen: "Construye una casa."',
      'La primera pregunta sería: ¿Con qué herramientas?',
      'Necesitarías martillos, planos, cemento, ladrillos, herramientas de medición y muchas cosas más.',
      'En el mundo de Java ocurre exactamente lo mismo:',
      'El terreno vacío es tu computador.',
      'La casa es la aplicación que quieres construir.',
      'Y las herramientas son el JDK.'
    ]
  },
  {
    type: 'section',
    title: '¿Qué es realmente el JDK?',
    paragraphs: [
      'JDK significa Java Development Kit. Es el conjunto de herramientas que necesita un desarrollador para crear aplicaciones Java.',
      'Sin el JDK sería como intentar construir una casa sin herramientas.',
      'Dentro del JDK encontramos: el compilador (javac), bibliotecas de Java, herramientas de depuración, herramientas de documentación y el entorno necesario para ejecutar aplicaciones.',
      'Podemos imaginarlo como una caja de herramientas profesional. Un carpintero tiene una caja de herramientas. Un mecánico tiene una caja de herramientas. Un desarrollador Java tiene el JDK.'
    ]
  },
  {
    type: 'section',
    title: 'JDK vs JRE: la analogía del conductor',
    paragraphs: [
      'Muchas personas confunden JDK y JRE. La diferencia es sencilla.',
      'Imagina que compras un automóvil. Si únicamente quieres conducirlo, no necesitas ser mecánico. Solo necesitas saber manejar. Eso es el JRE — permite ejecutar aplicaciones Java.',
      'Ahora imagina que además quieres fabricar automóviles, diseñarlos, modificar motores y construir nuevos modelos. Entonces necesitas muchas más herramientas. Eso es el JDK.',
      'Por eso podemos resumir: JRE = usar aplicaciones. JDK = crear aplicaciones.'
    ]
  },
  {
    type: 'section',
    title: 'Las tres grandes familias de Java',
    paragraphs: [
      'Imagina que Java es una empresa fabricante de vehículos. No todos los vehículos sirven para lo mismo. Un automóvil familiar no cumple la misma función que un camión de carga. Una motocicleta tampoco cumple la misma función que un bus. Por eso Java tiene distintas ediciones.'
    ],
    subsections: [
      {
        title: 'Java SE: el automóvil familiar',
        paragraphs: [
          'Java SE significa Standard Edition. Es la versión básica y más utilizada. Es el punto de partida para cualquier desarrollador Java.',
          'Con Java SE podemos crear: aplicaciones de escritorio, herramientas de gestión, programas educativos y aplicaciones generales.',
          'Es como el automóvil que utiliza una familia todos los días. Sirve para la mayoría de situaciones.'
        ]
      },
      {
        title: 'Java EE: el camión empresarial',
        paragraphs: [
          'Java EE significa Enterprise Edition. Está diseñada para grandes empresas: bancos, aerolíneas, universidades, hospitales y gobiernos.',
          'Sistemas que atienden miles o millones de usuarios. Si Java SE es un automóvil familiar, Java EE sería un enorme camión de carga capaz de transportar toneladas de información.',
          'Por eso los bancos siguen utilizando Java después de décadas. Necesitan estabilidad, seguridad y rendimiento.'
        ]
      },
      {
        title: 'Java ME: la motocicleta ligera',
        paragraphs: [
          'Java ME significa Micro Edition. Fue creada para dispositivos con pocos recursos: equipos pequeños, sistemas embebidos, dispositivos electrónicos e Internet de las Cosas (IoT).',
          'Si Java EE es un camión, Java ME sería una motocicleta ligera diseñada para moverse con pocos recursos.'
        ]
      }
    ]
  },
  {
    type: 'section',
    title: 'Los tipos de datos: las cajas de almacenamiento',
    paragraphs: [
      'Imagina que acabas de mudarte a una nueva casa. Necesitas guardar tus pertenencias. Pero no todo se almacena en la misma caja. Las joyas van en una caja pequeña. La ropa va en una caja mediana. El televisor necesita una caja grande. Los muebles requieren aún más espacio.',
      'En programación ocurre exactamente lo mismo. Los datos ocupan espacio. Por eso Java tiene distintos tipos de datos.'
    ],
    subsections: [
      { title: 'byte', paragraphs: ['Es la caja más pequeña. Sirve para almacenar números pequeños.'] },
      { title: 'short', paragraphs: ['Una caja un poco más grande. Permite almacenar números más grandes.'] },
      { title: 'int', paragraphs: ['La caja estándar. Es la más utilizada. La mayoría de los números enteros en Java se almacenan aquí.'] },
      { title: 'long', paragraphs: ['Una caja enorme. Para cantidades muy grandes.'] },
      { title: 'float y double', paragraphs: ['Son cajas especiales para números con decimales. Por ejemplo: 3.14, 15.8, 99.99. Double es más precisa que float.'] },
      { title: 'char', paragraphs: ['Es una caja para almacenar un único carácter. Ejemplos: A, B, Z.'] },
      { title: 'boolean', paragraphs: ['Es la caja más simple de todas. Solo puede guardar dos respuestas: Verdadero o Falso. Como un interruptor de luz. Encendido o apagado. Sí o no. True o False.'] }
    ]
  },
  {
    type: 'section',
    title: 'Visual Studio Code vs Cursor AI',
    paragraphs: [
      'Imagina dos cocinas. La primera tiene todos los utensilios necesarios. Puedes cocinar cualquier receta. Pero debes hacer casi todo manualmente. Esa cocina es Visual Studio Code.',
      'Ahora imagina una cocina inteligente. Mientras cocinas, alguien te ayuda. Te recomienda ingredientes. Corrige errores. Sugiere mejoras. Acelera tu trabajo. Esa cocina es Cursor AI.'
    ],
    subsections: [
      {
        title: 'Visual Studio Code',
        paragraphs: [
          'Es un editor de código extremadamente popular. Flexible. Ligero. Potente. Permite instalar miles de extensiones. Es como una navaja suiza para desarrolladores.'
        ]
      },
      {
        title: 'Cursor AI',
        paragraphs: [
          'Está construido sobre Visual Studio Code. Pero añade Inteligencia Artificial. Puede: explicar código, generar funciones, detectar errores, crear documentación y ayudar a programar más rápido. Es como trabajar con un asistente personal.'
        ]
      }
    ]
  },
  {
    type: 'section',
    title: '¿Qué es un AI Engineer?',
    paragraphs: [
      'Durante muchos años las empresas contrataban programadores. Hoy buscan algo más. Buscan personas capaces de combinar software con inteligencia artificial. Eso es un AI Engineer.',
      'Un AI Engineer no solo programa. También diseña soluciones inteligentes. Trabaja con: datos, modelos de IA, APIs, automatizaciones y sistemas inteligentes.',
      'Su objetivo es resolver problemas reales utilizando inteligencia artificial.'
    ]
  },
  {
    type: 'section',
    title: 'El rol del Java AI Engineer',
    paragraphs: [
      'Ahora unamos todas las piezas. Imagina que una empresa quiere construir un asistente inteligente para sus clientes. Necesitará: backend, bases de datos, interfaces de usuario, inteligencia artificial, automatización e integración con modelos de lenguaje.',
      'Ahí aparece el Java AI Engineer. Es un profesional que combina tres mundos: Backend Engineering, Full Stack Development y AI Engineering.',
      'No solamente desarrolla software. Construye productos inteligentes.',
      'Por eso aprender Java hoy ya no significa únicamente aprender a programar. Significa aprender a construir soluciones para el futuro.'
    ]
  },
  {
    type: 'conclusion',
    title: 'Reflexión Final',
    paragraphs: [
      'La Inteligencia Artificial está transformando el mundo. Sin embargo, las herramientas cambian constantemente. Lo que permanece son los fundamentos.',
      'Un desarrollador que comprende cómo funciona Java, qué es el JDK, cómo almacenar información y cómo construir software de calidad, tendrá la capacidad de aprender cualquier tecnología que aparezca en el futuro.',
      'La Inteligencia Artificial puede ayudarte a escribir código. Pero nunca podrá reemplazar la capacidad humana de analizar problemas, diseñar soluciones y tomar decisiones.',
      'Por eso el objetivo de esta formación no es solamente aprender Java. El verdadero objetivo es convertirte en un profesional capaz de construir el futuro utilizando tecnología.'
    ]
  }
];

function renderReading() {
  const container = document.getElementById('readingContent');
  if (!container) return;

  container.innerHTML = READING_CONTENT.map(block => {
    let html = `<div class="reading-block reading-block--${block.type}">`;
    html += `<h3>${block.title}</h3>`;

    block.paragraphs.forEach(p => {
      html += `<p>${p}</p>`;
    });

    if (block.subsections) {
      block.subsections.forEach(sub => {
        html += `<div class="reading-subsection">`;
        html += `<h4>${sub.title}</h4>`;
        sub.paragraphs.forEach(p => {
          html += `<p>${p}</p>`;
        });
        html += `</div>`;
      });
    }

    html += `</div>`;
    return html;
  }).join('');
}

document.addEventListener('DOMContentLoaded', renderReading);
