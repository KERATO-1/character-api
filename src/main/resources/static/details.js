function getCharacterId() {
  const params = new URLSearchParams(window.location.search);
  return params.get("id");
}

async function loadCharacterDetails() {
  const id = getCharacterId();
  const container = document.getElementById("details");

  try {
    const response = await fetch(`/characters/${id}`);

    if (!response.ok) {
      throw new Error("Character not found");
    }

    const character = await response.json();

    container.innerHTML = `
      <h1>${character.name}</h1>
      <img src="/naruto.jpg" width="200">
      <p>${character.description}</p>
      <p><strong>Universe:</strong> ${character.universe}</p>
      <p><strong>Species:</strong> ${character.species}</p>
      <p><strong>ID:</strong> ${character.characterId}</p>
    `;
  } catch (error) {
    console.error(error);
    container.innerHTML = "<p>Character not found.</p>";
  }
}

loadCharacterDetails();