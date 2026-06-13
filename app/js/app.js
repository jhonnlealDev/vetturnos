const SECTIONS = [
  { id: 'inicio', title: 'Inicio' },
  { id: 'jdk', title: '¿Qué es el JDK?' },
  { id: 'tipos-datos', title: 'Tipos de Datos en Java' },
  { id: 'editores', title: 'VS Code vs Cursor AI' },
  { id: 'ai-engineer', title: '¿Qué es un AI Engineer?' },
  { id: 'rol-java-ai', title: 'Rol del Java AI Engineer' },
  { id: 'lectura', title: 'Lectura de Reflexión' }
];

const STORAGE_KEY = 'clase1-progress';
const READING_KEY = 'clase1-reading-complete';

let visitedSections = new Set(['inicio']);

function loadProgress() {
  try {
    const saved = localStorage.getItem(STORAGE_KEY);
    if (saved) visitedSections = new Set(JSON.parse(saved));
  } catch (_) { /* ignore */ }
}

function saveProgress() {
  localStorage.setItem(STORAGE_KEY, JSON.stringify([...visitedSections]));
}

function getCurrentIndex() {
  const active = document.querySelector('.section.active');
  return SECTIONS.findIndex(s => s.id === active?.id);
}

function navigateTo(sectionId) {
  const section = document.getElementById(sectionId);
  if (!section) return;

  document.querySelectorAll('.section').forEach(s => s.classList.remove('active'));
  section.classList.add('active');

  document.querySelectorAll('.nav-link').forEach(link => {
    link.classList.toggle('active', link.dataset.section === sectionId);
  });

  const meta = SECTIONS.find(s => s.id === sectionId);
  document.getElementById('topbarTitle').textContent = meta?.title || '';

  visitedSections.add(sectionId);
  saveProgress();
  updateProgress();
  updateNavButtons();

  window.scrollTo({ top: 0, behavior: 'smooth' });
  closeSidebar();
}

function updateProgress() {
  const count = visitedSections.size;
  const total = SECTIONS.length;
  const pct = Math.round((count / total) * 100);

  document.getElementById('progressFill').style.width = `${pct}%`;
  document.getElementById('progressText').textContent = `${count} de ${total} secciones`;
}

function updateNavButtons() {
  const idx = getCurrentIndex();
  document.getElementById('prevBtn').disabled = idx <= 0;
  document.getElementById('nextBtn').disabled = idx >= SECTIONS.length - 1;
}

function openSidebar() {
  document.getElementById('sidebar').classList.add('open');
  document.getElementById('overlay').classList.add('active');
}

function closeSidebar() {
  document.getElementById('sidebar').classList.remove('open');
  document.getElementById('overlay').classList.remove('active');
}

function initNavigation() {
  document.querySelectorAll('.nav-link').forEach(link => {
    link.addEventListener('click', e => {
      e.preventDefault();
      navigateTo(link.dataset.section);
    });
  });

  document.querySelectorAll('[data-goto]').forEach(card => {
    card.addEventListener('click', () => navigateTo(card.dataset.goto));
  });

  document.querySelectorAll('.hero-actions a, .btn[href^="#"]').forEach(link => {
    link.addEventListener('click', e => {
      const href = link.getAttribute('href');
      if (href?.startsWith('#')) {
        e.preventDefault();
        navigateTo(href.slice(1));
      }
    });
  });

  document.getElementById('prevBtn').addEventListener('click', () => {
    const idx = getCurrentIndex();
    if (idx > 0) navigateTo(SECTIONS[idx - 1].id);
  });

  document.getElementById('nextBtn').addEventListener('click', () => {
    const idx = getCurrentIndex();
    if (idx < SECTIONS.length - 1) navigateTo(SECTIONS[idx + 1].id);
  });

  document.getElementById('menuBtn').addEventListener('click', openSidebar);
  document.getElementById('sidebarClose').addEventListener('click', closeSidebar);
  document.getElementById('overlay').addEventListener('click', closeSidebar);
}

function initCopyButtons() {
  document.querySelectorAll('.copy-btn').forEach(btn => {
    btn.addEventListener('click', () => {
      const target = document.getElementById(btn.dataset.copy);
      if (!target) return;

      navigator.clipboard.writeText(target.textContent.trim()).then(() => {
        const original = btn.textContent;
        btn.textContent = '¡Copiado!';
        setTimeout(() => { btn.textContent = original; }, 2000);
      });
    });
  });
}

function initReadingComplete() {
  const btn = document.getElementById('markCompleteBtn');
  const msg = document.getElementById('completeMsg');

  if (localStorage.getItem(READING_KEY) === 'true') {
    btn.textContent = '✓ Lectura completada';
    btn.disabled = true;
    btn.style.opacity = '0.7';
    msg.textContent = '¡Excelente! Has completado la lectura de reflexión.';
    msg.classList.add('visible');
  }

  btn.addEventListener('click', () => {
    localStorage.setItem(READING_KEY, 'true');
    visitedSections.add('lectura');
    saveProgress();
    updateProgress();

    btn.textContent = '✓ Lectura completada';
    btn.disabled = true;
    btn.style.opacity = '0.7';
    msg.textContent = '¡Excelente! Has completado la lectura de reflexión.';
    msg.classList.add('visible');
  });
}

function initKeyboardNav() {
  document.addEventListener('keydown', e => {
    if (e.target.tagName === 'INPUT' || e.target.tagName === 'TEXTAREA') return;

    const idx = getCurrentIndex();
    if (e.key === 'ArrowRight' && idx < SECTIONS.length - 1) {
      navigateTo(SECTIONS[idx + 1].id);
    } else if (e.key === 'ArrowLeft' && idx > 0) {
      navigateTo(SECTIONS[idx - 1].id);
    }
  });
}

document.addEventListener('DOMContentLoaded', () => {
  loadProgress();
  initNavigation();
  initCopyButtons();
  initReadingComplete();
  initKeyboardNav();
  updateProgress();
  updateNavButtons();

  const hash = window.location.hash.slice(1);
  if (hash && SECTIONS.some(s => s.id === hash)) {
    navigateTo(hash);
  }
});

window.addEventListener('hashchange', () => {
  const hash = window.location.hash.slice(1);
  if (hash && SECTIONS.some(s => s.id === hash)) {
    navigateTo(hash);
  }
});
