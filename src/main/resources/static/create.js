document.getElementById("create-form").addEventListener("submit", async function(event) {
  event.preventDefault();

  const character = {
    name: document.getElementById("name").value,
    description: document.getElementById("description").value,
    universe: document.getElementById("universe").value,
    species: document.getElementById("species").value
  };

  try {
    const response = await fetch("/characters", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(character)
    });

    if (!response.ok) {
      throw new Error("Failed to create character");
    }

    window.location.href = "index.html";
  } catch (error) {
    console.error(error);
    alert("Error creating character");
  }
});