<template>
  <section class="hero">
    <!-- Animated background grid -->
    <div class="grid-bg"></div>

    <!-- Floating accent blobs -->
    <div class="blob blob-1"></div>
    <div class="blob blob-2"></div>

    <div class="hero-inner">
      <!-- Left: main content -->
      <div class="hero-content">
        <div class="eyebrow">
          <span class="dot"></span>
          <span>Available for work</span>
        </div>

        <h1 class="hero-title">
          <span class="line line-1">Katlego</span>
          <span class="line line-2">Makoti</span>
        </h1>

        <p class="hero-role">Full-Stack Developer</p>

        <div class="tech-tags">
          <span class="tag" v-for="(tech, i) in techs" :key="tech" :style="{ animationDelay: `${0.8 + i * 0.1}s` }">
            {{ tech }}
          </span>
        </div>

        <div class="cta-row">
          <a href="#contact" class="btn-primary">Get in touch</a>
          <a href="#projects" class="btn-ghost">View work</a>
        </div>

        <div class="social-links">
          <a href="https://linkedin.com/in/katlego-makoti" target="_blank" class="social-link" aria-label="LinkedIn">
            <i class="fab fa-linkedin-in"></i>
          </a>
          <a href="https://github.com/katlegomakoti" target="_blank" class="social-link" aria-label="GitHub">
            <i class="fab fa-github"></i>
          </a>
        </div>
      </div>

      <!-- Right: decorative card -->
      <div class="hero-visual">
        <div class="profile-card">
          <div class="card-header">
            <div class="avatar-ring">
              <div class="avatar-inner">KM</div>
            </div>
            <div class="card-meta">
              <span class="card-name">Katlego Makoti</span>
              <span class="card-loc"><i class="fas fa-map-marker-alt"></i> Johannesburg, SA</span>
            </div>
          </div>

          <div class="card-stats">
            <div class="stat">
              <span class="stat-num">3+</span>
              <span class="stat-label">Years Exp.</span>
            </div>
            <div class="stat-divider"></div>
            <div class="stat">
              <span class="stat-num">10+</span>
              <span class="stat-label">Projects</span>
            </div>
            <div class="stat-divider"></div>
            <div class="stat">
              <span class="stat-num">7+</span>
              <span class="stat-label">Technologies</span>
            </div>
          </div>

          <div class="card-skills">
            <div class="skill-row" v-for="skill in skills" :key="skill.name">
              <span class="skill-name">{{ skill.name }}</span>
              <div class="skill-bar">
                <div class="skill-fill" :style="{ width: skill.level + '%', animationDelay: skill.delay }"></div>
              </div>
              <span class="skill-pct">{{ skill.level }}%</span>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Scroll indicator -->
    <div class="scroll-hint">
      <span>scroll</span>
      <div class="scroll-line"><div class="scroll-dot"></div></div>
    </div>
  </section>
</template>

<script lang="ts">
export default {
  name: 'HomePage',
  data() {
    return {
      techs: ['Angular', 'TypeScript', 'JavaScript', 'Java', 'Python', 'Salesforce'],
      skills: [
        { name: 'Frontend', level: 90, delay: '1.2s' },
        { name: 'Backend',  level: 82, delay: '1.4s' },
        { name: 'Database', level: 75, delay: '1.6s' },
        { name: 'DevOps',   level: 60, delay: '1.8s' },
      ]
    }
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Syne:wght@400;600;700;800&family=DM+Sans:ital,wght@0,300;0,400;0,500;1,300&display=swap');

/* ── Variables ── */
:root {
  --bg: #0a0a0f;
  --surface: #13131a;
  --surface2: #1c1c27;
  --accent: #5b6ef5;
  --accent2: #a78bfa;
  --green: #34d399;
  --text: #e8e8f0;
  --muted: #6b6b80;
  --border: rgba(255,255,255,0.07);
}

/* ── Base ── */
.hero {
  font-family: 'DM Sans', sans-serif;
  min-height: 100vh;
  background: var(--bg);
  color: var(--text);
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  position: relative;
  overflow: hidden;
  padding: 2rem;
}

/* ── Grid background ── */
.grid-bg {
  position: absolute;
  inset: 0;
  background-image:
    linear-gradient(rgba(91,110,245,0.04) 1px, transparent 1px),
    linear-gradient(90deg, rgba(91,110,245,0.04) 1px, transparent 1px);
  background-size: 60px 60px;
  mask-image: radial-gradient(ellipse 80% 80% at 50% 50%, black 40%, transparent 100%);
}

/* ── Blobs ── */
.blob {
  position: absolute;
  border-radius: 50%;
  filter: blur(80px);
  pointer-events: none;
  animation: blobFloat 8s ease-in-out infinite alternate;
}
.blob-1 {
  width: 500px; height: 500px;
  background: radial-gradient(circle, rgba(91,110,245,0.15), transparent 70%);
  top: -100px; left: -100px;
}
.blob-2 {
  width: 400px; height: 400px;
  background: radial-gradient(circle, rgba(167,139,250,0.12), transparent 70%);
  bottom: -80px; right: -80px;
  animation-delay: -4s;
}
@keyframes blobFloat {
  from { transform: translate(0, 0) scale(1); }
  to   { transform: translate(30px, 20px) scale(1.05); }
}

/* ── Layout ── */
.hero-inner {
  display: grid;
  grid-template-columns: 1fr 420px;
  gap: 4rem;
  align-items: center;
  max-width: 1100px;
  width: 100%;
  z-index: 1;
}

/* ── Left content ── */
.eyebrow {
  display: inline-flex;
  align-items: center;
  gap: 0.5rem;
  font-size: 0.8rem;
  font-weight: 500;
  color: var(--green);
  letter-spacing: 0.1em;
  text-transform: uppercase;
  margin-bottom: 1.5rem;
  animation: fadeUp 0.6s ease both;
}
.dot {
  width: 8px; height: 8px;
  background: var(--green);
  border-radius: 50%;
  animation: pulse 2s ease infinite;
}
@keyframes pulse {
  0%, 100% { box-shadow: 0 0 0 0 rgba(52,211,153,0.4); }
  50%       { box-shadow: 0 0 0 6px rgba(52,211,153,0); }
}

.hero-title {
  font-family: 'Syne', sans-serif;
  font-weight: 800;
  line-height: 0.9;
  margin: 0 0 1.2rem;
  display: flex;
  flex-direction: column;
}
.line {
  display: block;
  overflow: hidden;
}
.line-1 {
  font-size: clamp(3.5rem, 7vw, 6rem);
  color: var(--text);
  animation: slideIn 0.7s cubic-bezier(.16,1,.3,1) 0.1s both;
}
.line-2 {
  font-size: clamp(3.5rem, 7vw, 6rem);
  background: linear-gradient(135deg, var(--accent), var(--accent2));
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
  animation: slideIn 0.7s cubic-bezier(.16,1,.3,1) 0.2s both;
}
@keyframes slideIn {
  from { transform: translateY(100%); opacity: 0; }
  to   { transform: translateY(0);    opacity: 1; }
}

.hero-role {
  font-size: 1.1rem;
  color: var(--muted);
  font-weight: 300;
  letter-spacing: 0.05em;
  margin-bottom: 2rem;
  animation: fadeUp 0.6s ease 0.4s both;
}

/* ── Tech tags ── */
.tech-tags {
  display: flex;
  flex-wrap: wrap;
  gap: 0.5rem;
  margin-bottom: 2.5rem;
}
.tag {
  font-size: 0.75rem;
  font-weight: 500;
  padding: 0.3rem 0.8rem;
  border-radius: 100px;
  border: 1px solid var(--border);
  background: var(--surface);
  color: var(--muted);
  letter-spacing: 0.04em;
  animation: fadeUp 0.5s ease both;
  transition: border-color 0.2s, color 0.2s;
}
.tag:hover {
  border-color: var(--accent);
  color: var(--accent2);
}

/* ── CTA ── */
.cta-row {
  display: flex;
  gap: 1rem;
  margin-bottom: 2.5rem;
  animation: fadeUp 0.6s ease 0.7s both;
}
.btn-primary {
  padding: 0.75rem 1.75rem;
  background: linear-gradient(135deg, var(--accent), var(--accent2));
  color: white;
  border-radius: 8px;
  text-decoration: none;
  font-weight: 500;
  font-size: 0.9rem;
  transition: opacity 0.2s, transform 0.2s;
}
.btn-primary:hover { opacity: 0.85; transform: translateY(-2px); }

.btn-ghost {
  padding: 0.75rem 1.75rem;
  border: 1px solid var(--border);
  color: var(--text);
  border-radius: 8px;
  text-decoration: none;
  font-weight: 500;
  font-size: 0.9rem;
  transition: border-color 0.2s, transform 0.2s;
}
.btn-ghost:hover { border-color: var(--accent); transform: translateY(-2px); }

/* ── Social ── */
.social-links {
  display: flex;
  gap: 1rem;
  animation: fadeUp 0.6s ease 0.9s both;
}
.social-link {
  width: 40px; height: 40px;
  display: flex; align-items: center; justify-content: center;
  border: 1px solid var(--border);
  border-radius: 8px;
  color: var(--muted);
  font-size: 1rem;
  text-decoration: none;
  transition: border-color 0.2s, color 0.2s, transform 0.2s;
}
.social-link:hover {
  border-color: var(--accent);
  color: var(--accent2);
  transform: translateY(-3px);
}

/* ── Profile card ── */
.hero-visual {
  animation: fadeUp 0.8s ease 0.3s both;
}
.profile-card {
  background: var(--surface);
  border: 1px solid var(--border);
  border-radius: 20px;
  padding: 1.75rem;
  backdrop-filter: blur(20px);
  box-shadow: 0 40px 80px rgba(0,0,0,0.4), inset 0 1px 0 rgba(255,255,255,0.05);
}

.card-header {
  display: flex;
  align-items: center;
  gap: 1rem;
  margin-bottom: 1.5rem;
  padding-bottom: 1.5rem;
  border-bottom: 1px solid var(--border);
}
.avatar-ring {
  width: 56px; height: 56px;
  border-radius: 50%;
  padding: 2px;
  background: linear-gradient(135deg, var(--accent), var(--accent2));
  flex-shrink: 0;
}
.avatar-inner {
  width: 100%; height: 100%;
  background: var(--surface2);
  border-radius: 50%;
  display: flex; align-items: center; justify-content: center;
  font-family: 'Syne', sans-serif;
  font-weight: 700;
  font-size: 1rem;
  color: var(--accent2);
}
.card-name {
  display: block;
  font-family: 'Syne', sans-serif;
  font-weight: 700;
  font-size: 1rem;
  color: var(--text);
}
.card-loc {
  display: block;
  font-size: 0.78rem;
  color: var(--muted);
  margin-top: 0.2rem;
}
.card-loc i { margin-right: 0.3rem; color: var(--accent); }

/* Stats */
.card-stats {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 1.5rem;
  padding-bottom: 1.5rem;
  border-bottom: 1px solid var(--border);
}
.stat { text-align: center; }
.stat-num {
  display: block;
  font-family: 'Syne', sans-serif;
  font-weight: 800;
  font-size: 1.5rem;
  background: linear-gradient(135deg, var(--accent), var(--accent2));
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}
.stat-label {
  display: block;
  font-size: 0.7rem;
  color: var(--muted);
  text-transform: uppercase;
  letter-spacing: 0.06em;
  margin-top: 0.2rem;
}
.stat-divider {
  width: 1px; height: 36px;
  background: var(--border);
}

/* Skills */
.card-skills { display: flex; flex-direction: column; gap: 0.85rem; }
.skill-row {
  display: grid;
  grid-template-columns: 75px 1fr 36px;
  align-items: center;
  gap: 0.75rem;
}
.skill-name { font-size: 0.78rem; color: var(--muted); }
.skill-bar {
  height: 4px;
  background: var(--surface2);
  border-radius: 100px;
  overflow: hidden;
}
.skill-fill {
  height: 100%;
  border-radius: 100px;
  background: linear-gradient(90deg, var(--accent), var(--accent2));
  width: 0;
  animation: fillBar 1s cubic-bezier(.16,1,.3,1) forwards;
}
@keyframes fillBar {
  to { width: var(--target-width); }
}
.skill-pct { font-size: 0.7rem; color: var(--muted); text-align: right; }

/* ── Scroll hint ── */
.scroll-hint {
  position: absolute;
  bottom: 2rem;
  left: 50%;
  transform: translateX(-50%);
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 0.5rem;
  color: var(--muted);
  font-size: 0.65rem;
  letter-spacing: 0.15em;
  text-transform: uppercase;
  animation: fadeUp 1s ease 1.5s both;
}
.scroll-line {
  width: 1px; height: 40px;
  background: var(--border);
  position: relative;
  overflow: hidden;
}
.scroll-dot {
  width: 1px; height: 12px;
  background: var(--accent);
  position: absolute;
  top: -12px;
  animation: scrollDown 1.8s ease infinite;
}
@keyframes scrollDown {
  from { top: -12px; opacity: 1; }
  to   { top: 40px;  opacity: 0; }
}

/* ── Shared fadeUp ── */
@keyframes fadeUp {
  from { opacity: 0; transform: translateY(20px); }
  to   { opacity: 1; transform: translateY(0); }
}

/* ── Responsive ── */
@media (max-width: 900px) {
  .hero-inner {
    grid-template-columns: 1fr;
    text-align: center;
    gap: 3rem;
  }
  .eyebrow, .tech-tags, .cta-row, .social-links {
    justify-content: center;
  }
  .hero-visual { display: none; }
}
@media (max-width: 480px) {
  .line-1, .line-2 { font-size: 3rem; }
  .cta-row { flex-direction: column; }
}
</style>